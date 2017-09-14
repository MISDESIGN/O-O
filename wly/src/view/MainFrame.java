package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;

import dao.ExpressDao;
import entity.Express;

/**
 * 界面
 * 
 * @author mickkong
 *
 */
public class MainFrame extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JFrame frame;

	private JTable table;
	private static DefaultTableModel dtm;
	private JButton btnSearch;
	private JTextField textSearch;
	private JButton btnUpdate;

	public static void main(String[] args) {
		new MainFrame();
	}

	/**
	 * 构造方法
	 */
	public MainFrame() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		frame = new JFrame();
		frame.setTitle("快递签收");
		frame.setBounds(100, 100, 899, 449);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 893, 425);
		frame.getContentPane().add(tabbedPane);

		JPanel panelAddrList = new JPanel();
		tabbedPane.addTab("快递列表", null, panelAddrList, null);
		panelAddrList.setLayout(null);

		btnSearch = new JButton("查询");
		btnSearch.addActionListener(this);
		btnSearch.setBounds(785, 10, 93, 30);
		panelAddrList.add(btnSearch);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 50, 868, 296);
		panelAddrList.add(scrollPane);

		String[] header = { "编号", "快递单号", "发货人", "发货人联系方式", "发货人联系地址","收货人", "收货人联系方式", "收货人联系地址", "状态" };
		dtm = new DefaultTableModel(null, header);
		table = new JTable(dtm) {
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		scrollPane.setViewportView(table);

		textSearch = new JTextField();
		textSearch.setHorizontalAlignment(SwingConstants.CENTER);
		textSearch.setBounds(675, 15, 100, 21);
		panelAddrList.add(textSearch);
		textSearch.setColumns(10);

		JLabel lblName = new JLabel("快递单号：");
		lblName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblName.setBounds(571, 18, 100, 15);
		panelAddrList.add(lblName);

		btnUpdate = new JButton("签收");
		btnUpdate.addActionListener(this);
		btnUpdate.setBounds(785, 356, 93, 30);
		panelAddrList.add(btnUpdate);

		frame.setResizable(false);
		load();
		frame.setVisible(true);
	}

	/**
	 * 加载数据
	 */
	public static void load() {
		List<Express> list = new ArrayList<Express>();
		dtm.setRowCount(0);
		list = new ExpressDao().getList();
		for (Express express : list) {
			Object[] tableData = { express.getId(), express.getCode(), express.getSender(), express.getSender_phone(),
					express.getSender_phone(), express.getReceiver(), express.getReceiver_phone(),
					express.getReceiver_addr(), express.getState() };
			dtm.addRow(tableData);
		}
	}

	/**
	 * 事件处理
	 */
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnSearch) {
			/*
			 * 查询
			 */
			String code = textSearch.getText();
			List<Express> list = new ArrayList<Express>();
			dtm.setRowCount(0);
			list = new ExpressDao().searchByCode(code);
			for (Express express : list) {
				Object[] tableData = { express.getId(), express.getCode(), express.getSender(), express.getSender_phone(),
						express.getSender_phone(), express.getReceiver(), express.getReceiver_phone(),
						express.getReceiver_addr(), express.getState() };
				dtm.addRow(tableData);
			}
		} else if (e.getSource() == btnUpdate) {
			/*
			 * 签收
			 */
			int index = table.getSelectedRow();
			if (index == -1) {
				JOptionPane.showMessageDialog(this, "请先选中一行数据");
				return;
			}
			int id = (Integer) dtm.getValueAt(index, 0);
			new ExpressDao().update(id);
			load();
		}
	}
}
