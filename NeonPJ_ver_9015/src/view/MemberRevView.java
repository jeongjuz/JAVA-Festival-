package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.font.TextHitInfo;
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

import model.MemberRevDAO;
import model.rec.MemberBoothVO;
import model.rec.MemberReservationVO;
import model.rec.MemberRevVO;
import view.MemberBoothView.ListTableModel;

import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

public class MemberRevView extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textBooth;
	private JTable table;
	private JTextField textField_8;
	private JTextField textCount;
	private JTextField textRevtime;
	private JTextField textWaitTeam;
	private JTextField textWaitNo;
	private ListTableModel listTableModel;
	MemberRevDAO dao;
	private int festNo;
	private int revNo;
	private String id;
	private String name;

	/**
	 * Create the panel.
	 */
	public MemberRevView(int festNo, String id) {
		this.festNo = festNo;
		this.id = id;

		try {
			dao = new MemberRevDAO();
		} catch (Exception e) {
			// TODO: handle exception
		}
		setLayout(null);
		setBounds(12, 62, 984, 657);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(510, 96, 430, 512);
		add(scrollPane);

		table = new JTable();
		table.setFont(new Font("한컴 고딕", Font.PLAIN, 12));
		scrollPane.setViewportView(table);
		listTableModel = new ListTableModel();
		table.setBorder(new LineBorder(new Color(0, 0, 0)));

		JLabel lblNewLabel = new JLabel("부스명");
		lblNewLabel.setForeground(new Color(249, 255, 249));
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setFont(new Font("한컴 고딕", Font.PLAIN, 20));
		lblNewLabel.setBounds(46, 42, 88, 33);
		add(lblNewLabel);

		textBooth = new JTextField();
		textBooth.setFont(new Font("한컴 고딕", Font.PLAIN, 20));
		textBooth.setBounds(134, 42, 330, 33);
		add(textBooth);
		textBooth.setColumns(10);

		textField_8 = new JTextField();
		textField_8.setToolTipText("");
		textField_8.setBounds(510, 42, 430, 33);
		add(textField_8);
		textField_8.setColumns(10);

		JLabel lblNewLabel_1_2 = new JLabel("인원수");
		lblNewLabel_1_2.setForeground(new Color(249, 255, 249));
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_2.setFont(new Font("한컴 고딕", Font.PLAIN, 20));
		lblNewLabel_1_2.setBounds(46, 97, 88, 33);
		add(lblNewLabel_1_2);

		textCount = new JTextField();
		textCount.setFont(new Font("한컴 고딕", Font.PLAIN, 20));
		textCount.setColumns(10);
		textCount.setBounds(134, 97, 330, 33);
		add(textCount);

		JLabel lblNewLabel_1_2_1 = new JLabel("예약시간");
		lblNewLabel_1_2_1.setForeground(new Color(249, 255, 249));
		lblNewLabel_1_2_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_2_1.setFont(new Font("한컴 고딕", Font.PLAIN, 20));
		lblNewLabel_1_2_1.setBounds(46, 151, 88, 33);
		add(lblNewLabel_1_2_1);

		textRevtime = new JTextField();
		textRevtime.setFont(new Font("한컴 고딕", Font.PLAIN, 20));
		textRevtime.setColumns(10);
		textRevtime.setBounds(134, 151, 330, 33);
		add(textRevtime);

		JLabel lblNewLabel_1_2_2 = new JLabel("대기팀수");
		lblNewLabel_1_2_2.setForeground(new Color(249, 255, 249));
		lblNewLabel_1_2_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_2_2.setFont(new Font("한컴 고딕", Font.PLAIN, 20));
		lblNewLabel_1_2_2.setBounds(46, 205, 88, 33);
		add(lblNewLabel_1_2_2);

		textWaitTeam = new JTextField();
		textWaitTeam.setFont(new Font("한컴 고딕", Font.PLAIN, 20));
		textWaitTeam.setColumns(10);
		textWaitTeam.setBounds(134, 205, 330, 33);
		add(textWaitTeam);

		JLabel lblNewLabel_1_2_3 = new JLabel("대기번호");
		lblNewLabel_1_2_3.setForeground(new Color(249, 255, 249));
		lblNewLabel_1_2_3.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_2_3.setFont(new Font("한컴 고딕", Font.PLAIN, 20));
		lblNewLabel_1_2_3.setBounds(46, 259, 88, 33);
		add(lblNewLabel_1_2_3);

		textWaitNo = new JTextField();
		textWaitNo.setFont(new Font("한컴 고딕", Font.PLAIN, 20));
		textWaitNo.setColumns(10);
		textWaitNo.setBounds(134, 259, 330, 33);
		add(textWaitNo);

		JButton btnRevCansel = new JButton("취소");
		btnRevCansel.setBounds(215, 326, 100, 40);
		add(btnRevCansel);
		selectBoothList();

		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int row = table.getSelectedRow();
				int col = 0;
				int col2 = 1;
				revNo = Integer.parseInt((String) table.getValueAt(row, col));
				name = (String) table.getValueAt(row, col2);
				MemberRevVO vo = new MemberRevVO();

				try {
					vo = dao.findByNum(revNo, name);
					textWaitNo.setText(String.valueOf(vo.getRevNo()));
					textCount.setText(String.valueOf(vo.getCount()));
					textBooth.setText(vo.getBoothname());
					textRevtime.setText(vo.getWaitTime());
					textWaitTeam.setText(String.valueOf(vo.getWaitTeam()));
				} catch (Exception e2) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(null, e2.getMessage());
				}
				// 검색된 비디오를 화면에 출력
			}
		});

		btnRevCansel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					dao.cancleBoothRev(revNo);
					selectBoothList();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		
		JLabel background = new JLabel("");
		background.setIcon(new ImageIcon(MemberBoothView.class.getResource("/img/background_2.jpeg")));
		background.setBounds(0, 0, 984, 657);
		add(background);

	}

	void selectBoothList() {
		try {
			ArrayList list = dao.memberRevList(this.festNo, this.id);
			listTableModel.data = list;
			table.setModel(listTableModel);
			listTableModel.fireTableDataChanged();

		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	// 테이블 모델 클래스
	class ListTableModel extends AbstractTableModel {
		ArrayList data = new ArrayList();
		String[] colNames = { "예약번호", "부스명", "회원아이디", "인원수", "예약시간" };

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
