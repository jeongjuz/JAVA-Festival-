package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

import model.BoothRevDAO;
import model.rec.BoothProgramVO;
import model.rec.BoothRevVo;

import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

public class BoothRevView extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField tfBoothRevName;
	private JTextField tfBoothRevCount;
	private JTable tblReservation;
	private JTextField textField_8;
	private JTextField tfBoothRevOrder;
	private JTextField tfBoothRevNo;
	private JTextField tfBoothRevTime;
	private BoothRevDAO boothRevDAO;
	private ListTableModel listTableModel;
	private int boothNo;

	/**
	 * Create the panel.
	 */
	public BoothRevView(int boothNo) {
		setLayout(null);
		setBounds(12, 62, 984, 657);
		this.boothNo = boothNo;

		try {
			boothRevDAO = new BoothRevDAO();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(510, 96, 430, 512);
		add(scrollPane);

		tblReservation = new JTable();
		tblReservation.setFont(new Font("\uD55C\uCEF4 \uACE0\uB515", tblReservation.getFont().getStyle(), 12));
		scrollPane.setViewportView(tblReservation);
		tblReservation.setModel(new DefaultTableModel(
				new Object[][] { { null, null, null, null, null }, { null, null, null, null, null },
						{ null, null, null, null, "" }, { null, null, null, null, null },
						{ null, null, null, null, null }, },
				new String[] { "\uACF5\uC5F0\uBA85", "\uACF5\uC5F0\uC7A5\uC18C", "\uC2DC\uC791\uC2DC\uAC04",
						"\uC885\uB8CC\uC2DC\uAC04", "\uCD9C\uC5F0\uC9C4" }));
		tblReservation.setBorder(new LineBorder(new Color(0, 0, 0)));

		JLabel lblNewLabel = new JLabel("예약자명");
		lblNewLabel.setForeground(new Color(250, 255, 248));
		lblNewLabel.setFont(new Font("\uD55C\uCEF4 \uACE0\uB515", lblNewLabel.getFont().getStyle(), 20));
		lblNewLabel.setBounds(46, 46, 88, 25);
		add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("예약인원");
		lblNewLabel_1.setForeground(new Color(250, 255, 248));
		lblNewLabel_1.setFont(new Font("\uD55C\uCEF4 \uACE0\uB515", lblNewLabel.getFont().getStyle(), 20));
		lblNewLabel_1.setBounds(46, 92, 88, 25);
		add(lblNewLabel_1);

		tfBoothRevName = new JTextField();
		tfBoothRevName.setFont(new Font("\uD55C\uCEF4 \uACE0\uB515", tfBoothRevName.getFont().getStyle(), 14));
		tfBoothRevName.setBounds(134, 46, 330, 25);
		add(tfBoothRevName);
		tfBoothRevName.setColumns(10);

		tfBoothRevCount = new JTextField();
		tfBoothRevCount.setFont(new Font("\uD55C\uCEF4 \uACE0\uB515", tfBoothRevCount.getFont().getStyle(), 14));
		tfBoothRevCount.setColumns(10);
		tfBoothRevCount.setBounds(134, 92, 330, 25);
		add(tfBoothRevCount);

		textField_8 = new JTextField();
		textField_8.setFont(new Font("\uD55C\uCEF4 \uACE0\uB515", textField_8.getFont().getStyle(), 16));
		textField_8.setToolTipText("");
		textField_8.setBounds(510, 42, 430, 40);
		add(textField_8);
		textField_8.setColumns(10);

		JButton btnBoothEnter = new JButton("입장");
		btnBoothEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int boothRevNo = Integer.parseInt(tfBoothRevNo.getText());
				try {
					boothRevDAO.enterBooth(boothRevNo);
					JOptionPane.showMessageDialog(null,"입장이 완료되었습니다.");
					selectBoothRevList();
					clearScreen();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnBoothEnter.setFont(new Font("\uD55C\uCEF4 \uACE0\uB515", btnBoothEnter.getFont().getStyle(), 20));
		btnBoothEnter.setBounds(46, 568, 100, 40);
		add(btnBoothEnter);

		JButton btnBoothRevCancle = new JButton("취소");
		btnBoothRevCancle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int boothRevNo = Integer.parseInt(tfBoothRevNo.getText());
				try {
					boothRevDAO.cancleBoothRev(boothRevNo);
					JOptionPane.showMessageDialog(null,"예약이 취소되었습니다.");
					selectBoothRevList();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnBoothRevCancle.setFont(new Font("\uD55C\uCEF4 \uACE0\uB515", btnBoothEnter.getFont().getStyle(), 20));
		btnBoothRevCancle.setBounds(365, 568, 100, 40);
		add(btnBoothRevCancle);

		JLabel lblNewLabel_1_1 = new JLabel("대기순서");
		lblNewLabel_1_1.setForeground(new Color(250, 255, 248));
		lblNewLabel_1_1.setFont(new Font("\uD55C\uCEF4 \uACE0\uB515", lblNewLabel_1_1.getFont().getStyle(), 20));
		lblNewLabel_1_1.setBounds(46, 136, 88, 25);
		add(lblNewLabel_1_1);

		tfBoothRevOrder = new JTextField();
		tfBoothRevOrder.setFont(new Font("\uD55C\uCEF4 \uACE0\uB515", tfBoothRevOrder.getFont().getStyle(), 14));
		tfBoothRevOrder.setColumns(10);
		tfBoothRevOrder.setBounds(134, 136, 330, 25);
		add(tfBoothRevOrder);

		JLabel lblNewLabel_1_2 = new JLabel("대기번호");
		lblNewLabel_1_2.setForeground(new Color(250, 255, 248));
		lblNewLabel_1_2.setFont(new Font("\uD55C\uCEF4 \uACE0\uB515", lblNewLabel_1_2.getFont().getStyle(), 20));
		lblNewLabel_1_2.setBounds(46, 183, 88, 25);
		add(lblNewLabel_1_2);

		tfBoothRevNo = new JTextField();
		tfBoothRevNo.setFont(new Font("\uD55C\uCEF4 \uACE0\uB515", tfBoothRevNo.getFont().getStyle(), 14));
		tfBoothRevNo.setColumns(10);
		tfBoothRevNo.setBounds(134, 183, 330, 25);
		add(tfBoothRevNo);

		JLabel lblNewLabel_1_3 = new JLabel("예약시각");
		lblNewLabel_1_3.setForeground(new Color(250, 255, 248));
		lblNewLabel_1_3.setFont(new Font("\uD55C\uCEF4 \uACE0\uB515", lblNewLabel_1_3.getFont().getStyle(), 20));
		lblNewLabel_1_3.setBounds(46, 226, 80, 25);
		add(lblNewLabel_1_3);

		tfBoothRevTime = new JTextField();
		tfBoothRevTime.setFont(new Font("\uD55C\uCEF4 \uACE0\uB515", tfBoothRevTime.getFont().getStyle(), 14));
		tfBoothRevTime.setColumns(10);
		tfBoothRevTime.setBounds(134, 228, 330, 25);
		add(tfBoothRevTime);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setForeground(new Color(129, 129, 129));
		separator.setBackground(new Color(179, 179, 179));
		separator.setBounds(486, 42, 2, 566);
		add(separator);

		listTableModel = new ListTableModel();
		selectBoothRevList();

		tblReservation.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				int row = tblReservation.getSelectedRow();
				int col = 3;
				int boothRevNo = (int) tblReservation.getValueAt(row, col);
				try {
					BoothRevVo vo = boothRevDAO.boothRevDetail(boothRevNo, boothNo);
					System.out.println(vo.getMemberName());
					tfBoothRevName.setText(vo.getMemberName());
					tfBoothRevCount.setText(Integer.toString(vo.getBoothRevCount()));
					tfBoothRevOrder.setText(Integer.toString(vo.getBoothRevOrder()));
					tfBoothRevNo.setText(Integer.toString(vo.getBoothRevNo()));
					tfBoothRevTime.setText(vo.getBoothRevTime());
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		
		JLabel background = new JLabel("");
		background.setIcon(new ImageIcon(MemberBoothView.class.getResource("/img/background_2.jpeg")));
		background.setBounds(0, 0, 984, 657);
		add(background);

	}

	protected void clearScreen() {
		// TODO Auto-generated method stub
		tfBoothRevName.setText("");
		tfBoothRevCount.setText("");
		tfBoothRevOrder.setText("");
		tfBoothRevNo.setText("");
		tfBoothRevTime.setText("");
		
	}

	void selectBoothRevList() {
		try {
			ArrayList list = boothRevDAO.boothRevList(boothNo);
			listTableModel.data = list;
			tblReservation.setModel(listTableModel);
			listTableModel.fireTableDataChanged();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	class ListTableModel extends AbstractTableModel {
		ArrayList data = new ArrayList();

		// 예약자명, 예약인원, 예약순번(대기순서), 대기번호(시퀀스)
		String[] colNames = { "예약자명", "예약인원", "대기순서", "대기번호" };

		@Override
		public int getColumnCount() {
			// TODO Auto-generated method stub
			return colNames.length;
		}

		@Override
		public int getRowCount() {
			// TODO Auto-generated method stub
			return data.size();
		}

		@Override
		public Object getValueAt(int rowIndex, int columnIndex) {
			// TODO Auto-generated method stub
			ArrayList temp = (ArrayList) data.get(rowIndex);
			return temp.get(columnIndex);
		}

		public String getColumnName(int col) {
			return colNames[col];
		}
	}

}
