package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

import model.MemberBoothDAO;
import model.MemberReservationDAO;
import model.rec.MemberBoothVO;
import model.rec.MemberReservationVO;

public class MemberBoothView extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField tfboothname;
	private JTextField tfboothlocation;
	private JTable tbboothlist;
	private MemberBoothDAO dao;
	private MemberReservationDAO dao2;
	private ListTableModel listTableModel;
	private JTextField MBsearch;
	private JTextField tfstarttime;
	private JTextField tfendtime;
	private JTextField textCount;
	private JButton btnboothdelete;
	private int festNo;
	private int boothNo;
	private String id;
	private JComboBox MBcombox;
	private MemberRevView memberRevView;
	private JTextArea tfboothcontent;

	/**
	 * Create the panel.
	 * 
	 * @param tbfestivallist
	 * @return
	 */

	public MemberBoothView(int festNo, String id, MemberRevView memberRevView) {
		this.festNo = festNo;
		this.id = id;
		this.memberRevView = memberRevView;
		try {
			dao = new MemberBoothDAO();
			dao2 = new MemberReservationDAO();
		}

		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		setLayout(null);
		setBounds(12, 62, 984, 657);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(510, 96, 430, 512);
		add(scrollPane);

		listTableModel = new ListTableModel();
		tbboothlist = new JTable(listTableModel);
		tbboothlist.setFont(new Font("?????? ??????", Font.PLAIN, 12));
		scrollPane.setViewportView(tbboothlist);
		tbboothlist.setModel(new DefaultTableModel(
				new Object[][] { { null, null, null, null, null, null }, { null, null, null, null, null, null },
						{ null, null, null, null, "", null }, { null, null, null, null, null, null },
						{ null, null, null, null, null, null }, },
				new String[] { "\uBD80\uC2A4\uBC88\uD638", "\uBD80\uC2A4\uBA85", "\uBD80\uC2A4\uC704\uCE58",
						"\uC2DC\uC791\uC2DC\uAC04", "\uC885\uB8CC\uC2DC\uAC04", "\uBD80\uC2A4\uB0B4\uC6A9" }));
		tbboothlist.setBorder(new LineBorder(new Color(0, 0, 0)));

		JLabel lblboothname = new JLabel("?????????");
		lblboothname.setForeground(new Color(249, 255, 249));
		lblboothname.setFont(new Font("?????? ??????", Font.PLAIN, 20));
		lblboothname.setBounds(46, 46, 88, 33);
		add(lblboothname);

		JLabel lblboothlocation = new JLabel("????????????");
		lblboothlocation.setForeground(new Color(249, 255, 249));
		lblboothlocation.setFont(new Font("?????? ??????", Font.PLAIN, 20));
		lblboothlocation.setBounds(46, 92, 88, 33);
		add(lblboothlocation);

		JLabel lblboothcontent = new JLabel("????????????");
		lblboothcontent.setForeground(new Color(249, 255, 249));
		lblboothcontent.setFont(new Font("?????? ??????", Font.PLAIN, 20));
		lblboothcontent.setBounds(46, 183, 88, 375);
		add(lblboothcontent);

		tfboothname = new JTextField();
		tfboothname.setFont(new Font("?????? ??????", Font.PLAIN, 20));
		tfboothname.setBounds(134, 45, 330, 33);
		add(tfboothname);
		tfboothname.setColumns(10);

		tfboothlocation = new JTextField();
		tfboothlocation.setFont(new Font("?????? ??????", Font.PLAIN, 20));
		tfboothlocation.setColumns(10);
		tfboothlocation.setBounds(134, 92, 330, 33);
		add(tfboothlocation);

		tfboothcontent = new JTextArea();
		tfboothcontent.setFont(new Font("?????? ??????", Font.PLAIN, 20));
		tfboothcontent.setBounds(134, 183, 330, 375);
		add(tfboothcontent);

		MBsearch = new JTextField();
		MBsearch.setFont(new Font("?????? ??????", Font.PLAIN, 20));
		MBsearch.setToolTipText("");
		MBsearch.setBounds(610, 46, 225, 33);
		add(MBsearch);
		MBsearch.setColumns(10);

		JButton btnreservation = new JButton("??????");
		btnreservation.setFont(new Font("?????? ??????", Font.PLAIN, 20));
		btnreservation.setBounds(365, 568, 100, 33);
		add(btnreservation);

		JLabel lblboothstart = new JLabel("????????????");
		lblboothstart.setForeground(new Color(249, 255, 249));
		lblboothstart.setFont(new Font("?????? ??????", Font.PLAIN, 20));
		lblboothstart.setBounds(46, 137, 88, 33);
		add(lblboothstart);

		tfstarttime = new JTextField();
		tfstarttime.setFont(new Font("?????? ??????", Font.PLAIN, 20));
		tfstarttime.setColumns(10);
		tfstarttime.setBounds(134, 137, 113, 33);
		add(tfstarttime);

		JLabel lblboothend = new JLabel("????????????");
		lblboothend.setForeground(new Color(249, 255, 249));
		lblboothend.setFont(new Font("?????? ??????", Font.PLAIN, 20));
		lblboothend.setBounds(263, 137, 88, 33);
		add(lblboothend);

		tfendtime = new JTextField();
		tfendtime.setFont(new Font("?????? ??????", Font.PLAIN, 20));
		tfendtime.setColumns(10);
		tfendtime.setBounds(351, 137, 113, 33);
		add(tfendtime);

		textCount = new JTextField();
		textCount.setFont(new Font("?????? ??????", Font.PLAIN, 20));
		textCount.setColumns(10);
		textCount.setBounds(134, 568, 113, 33);
		add(textCount);

		JLabel lblpeople = new JLabel("??????");
		lblpeople.setForeground(new Color(249, 255, 249));
		lblpeople.setHorizontalAlignment(SwingConstants.LEFT);
		lblpeople.setFont(new Font("?????? ??????", Font.PLAIN, 20));
		lblpeople.setBounds(46, 568, 88, 33);
		add(lblpeople);

		/////////////////////////////
		// ?????? ?????? ?????? ?????? (new)
		JButton btnShowList = new JButton("????????????");
		btnShowList.setFont(new Font("?????? ??????", Font.PLAIN, 15));
		btnShowList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectBoothList();
			}
		});
		btnShowList.setBounds(849, 46, 91, 33);
		add(btnShowList);

		String searchText[] = { "?????????", "????????????", "????????????", "????????????", "????????????" };
		MBcombox = new JComboBox(searchText);
		MBcombox.setFont(new Font("Dialog", Font.PLAIN, 12));
		MBcombox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

		MBsearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int sel = MBcombox.getSelectedIndex();
				String text = MBsearch.getText();

				try {
					ArrayList list = dao.bthsearch(festNo, sel, text);
					listTableModel.data = list;
					tbboothlist.setModel(listTableModel);
					listTableModel.fireTableDataChanged();
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
					JOptionPane.showMessageDialog(null, "???????????? ??????" + e2.getMessage());
				}
			}
		});

		MBcombox.setBounds(510, 46, 88, 33);
		add(MBcombox);
		// ?????????????????? ???
		/////////////////////////////

		listTableModel = new ListTableModel();
		selectBoothList();

		// ??????????????????
		btnreservation.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int count = Integer.parseInt(textCount.getText());
				MemberReservationVO vo = new MemberReservationVO(boothNo, count, id);
				try {
					dao2.insertreservation(vo);
					JOptionPane.showMessageDialog(null, "?????????????????????.");
					memberRevView.selectBoothList();
					clearScreen();
				} catch (Exception e2) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(null, e2.getMessage());
				}

			}
		});

//		tbboothlist.addMouseListener(new MouseAdapter() {
//			public void mouseClicked(MouseEvent e) {// ?????????????????????
//				int row = tbboothlist.getSelectedRow();
//				int col = 0;// ????????? ???????????? ??????????????? ????????? ?????????
//				int boothNo = Integer.parseInt((String) tbboothlist.getValueAt(row, col));
//
//				MemberBoothVO vo = new MemberBoothVO();
//				try {
//					vo = dao.boothmodel(boothNo);
//				} catch (Exception e1) {
//					// TODO: handle exception
//					JOptionPane.showMessageDialog(null, "??????????????????:" + e1.getMessage());
//				}
//				// ????????? ???????????? ????????? ??????
//				tfboothname.setText((vo.getName()));
//				tfboothlocation.setText(vo.getPlace());
//				;
//				tfstarttime.setText(vo.getStarttime());
//				tfendtime.setText(vo.getEndtime());
//				tfboothcontent.setText(vo.getContent());
//
//			}
//		});

		tbboothlist.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {
				int row = tbboothlist.getSelectedRow();
				int col = 0;
				System.out.println(tbboothlist.getValueAt(row, col));
				boothNo = Integer.parseInt((String) tbboothlist.getValueAt(row, col));

				MemberBoothVO vo = new MemberBoothVO();

				try {
					vo = dao.findByNum(boothNo, festNo);
					tfboothname.setText(String.valueOf(vo.getName()));
					tfboothlocation.setText(vo.getPlace());
					tfstarttime.setText(vo.getStarttime());
					tfendtime.setText(vo.getEndtime());
					tfboothcontent.setText(vo.getContent());
				} catch (Exception e2) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(null, e2.getMessage());
				}
				// ????????? ???????????? ????????? ??????
			}
		});
		
		JLabel background = new JLabel("");
		background.setIcon(new ImageIcon(MemberBoothView.class.getResource("/img/background_2.jpeg")));
		background.setBounds(0, 0, 984, 657);
		add(background);
	}

	protected void clearScreen() {
		tfboothname.setText("");
		tfboothlocation.setText("");
		tfstarttime.setText("");
		tfendtime.setText("");
		tfboothcontent.setText("");
		
	}

	void selectBoothList() {
		System.out.println("selectBoothList");
		try {
			ArrayList list = dao.boothlist(this.festNo);
			listTableModel.data = list;
			tbboothlist.setModel(listTableModel);
			listTableModel.fireTableDataChanged();

		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	// ????????? ?????? ?????????
	class ListTableModel extends AbstractTableModel {
		ArrayList data = new ArrayList();
		String[] colNames = { "????????????", "?????????", "????????????", "????????????", "????????????", "????????????" };

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
