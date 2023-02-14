package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

import model.BoothSelectDAO;
import model.BoothWriteDAO;
import model.rec.BoothWriteVO;
import view.MemberBoothView.ListTableModel;

public class BoothManagementView extends JFrame {

	private JPanel contentPane;

	private JTable table;
	private JTextField txtBoothName;
	private JTextField txtBoothBegin;
	private JTable table_1;
	private JTextField txtBoothMaxP;
	private JTextField txtBoothEnd;
	private JTextField txtMyName;
	private JTextField txtMyId;
	private JTextField txtMyPw;
	private JTextField txtBOD;
	private JTextField txtPhoneNum;
	private JTable tblFestivalList;
	private JComboBox comBoothType;
	private BoothWriteDAO dao;
	private BoothSelectDAO boothSelectDAO;
	private JTextField txtBoothContent;

	private JTable tbfestivallist;

	private ListTableModel listTableModel;
	private ListTableBoothModel boothModel;

	private JTable tblfestivallist;
	private JTable tblBoothFestivalList;

	private int festivalNo;
	private JTable tblBoothList;

	private String loginMemberId;

	protected int boothNo;

	private JComboBox comBoothType_1;

	private JComboBox comBoothRank;

	/**
	 * Create the frame.
	 * 
	 * @wbp.parser.constructor
	 */
	public BoothManagementView(int i, String loginMemberId) {
		BoothManagementView frame = new BoothManagementView(loginMemberId);
		frame.setVisible(true);
	}

	public BoothManagementView(String loginMemberId) {
		this.loginMemberId = loginMemberId;

		try {
			dao = new BoothWriteDAO();
			boothSelectDAO = new BoothSelectDAO(loginMemberId);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1024, 768);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		// 축제관리
		// 패널-------------------------------------------------------------------------------------------------------------------------------

		JPanel paBoothmanager = new JPanel();
		paBoothmanager.setBounds(0, 0, 1008, 729);
		contentPane.add(paBoothmanager);
		paBoothmanager.setLayout(null);

		// add(writeView);

		BoothProgramView BoothProgramView_1 = new BoothProgramView(boothNo);
		BoothRevView BoothRevView_1 = new BoothRevView(boothNo);
		BoothInventoryView BoothInventoryView_1 = new BoothInventoryView(festivalNo);
		// getContentPane();
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 67, 1008, 662);
		paBoothmanager.add(tabbedPane);

		tabbedPane.addTab("프로그램관리", BoothProgramView_1);
		tabbedPane.addTab("재고관리", BoothInventoryView_1);
		tabbedPane.addTab("예약관리", BoothRevView_1);

		JButton btnGoToBack = new JButton("뒤로가기");
		btnGoToBack.setFont(new Font("휴먼모음T", Font.PLAIN, 15));

		btnGoToBack.setBounds(870, 25, 100, 30);
		paBoothmanager.add(btnGoToBack);

		JLabel festManagerName = new JLabel(loginMemberId);
		festManagerName.setFont(new Font("휴먼모음T", Font.PLAIN, 20));
		festManagerName.setBounds(680, 25, 150, 30);
		paBoothmanager.add(festManagerName);

		JLabel lblFestName = new JLabel("축제명");
		lblFestName.setFont(new Font("휴먼모음T", Font.PLAIN, 25));
		lblFestName.setBounds(25, 25, 200, 30);
		paBoothmanager.add(lblFestName);

		JLabel lblBoothName = new JLabel("부스명");
		lblBoothName.setFont(new Font("휴먼모음T", Font.PLAIN, 22));
		lblBoothName.setBounds(275, 25, 200, 30);
		paBoothmanager.add(lblBoothName);

		// 버튼
		// 이벤트---------------------------------------------------------------------------------------------------
		// festivalWrite.setVisible(true);

		// 축제 리스트

		// 뒤로가기
		

		// 화면 전환
		// --------------------------------------------------------------------------

		// 초기 화면
		paBoothmanager.setVisible(false);

		// 축제리스트 패널
		JPanel paBoothList = new JPanel();
		paBoothList.setBounds(270, 0, 738, 729);
		contentPane.add(paBoothList);
		paBoothList.setLayout(null);

		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(0, 187, 738, 520);
		paBoothList.add(scrollPane_2);

		tblBoothList = new JTable();
		scrollPane_2.setViewportView(tblBoothList);

		JPanel panel = new JPanel();
		panel.setBackground(Color.ORANGE);
		panel.setBounds(0, 38, 738, 125);
		paBoothList.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel_3 = new JLabel("내 부스 리스트");
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setFont(new Font("휴먼모음T", Font.PLAIN, 22));
		lblNewLabel_3.setBounds(50, 50, 150, 40);
		panel.add(lblNewLabel_3);

		JButton btnGoToTab = new JButton("관리화면으로 이동");
		btnGoToTab.setFont(new Font("휴먼모음T", Font.PLAIN, 15));
		btnGoToTab.setBounds(530, 50, 170, 40);
		panel.add(btnGoToTab);

		paBoothList.setVisible(false);

		paBoothList.setVisible(true);

		//

		JPanel paMyInfo = new JPanel();
		paMyInfo.setLayout(null);
		paMyInfo.setBounds(270, 0, 738, 729);
		contentPane.add(paMyInfo);

		JLabel lblNewLabel_4_1 = new JLabel("이름");
		lblNewLabel_4_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4_1.setFont(new Font("휴먼모음T", Font.PLAIN, 20));
		lblNewLabel_4_1.setBounds(74, 190, 100, 40);
		paMyInfo.add(lblNewLabel_4_1);

		txtMyName = new JTextField();
		txtMyName.setColumns(10);
		txtMyName.setBounds(174, 190, 490, 40);
		paMyInfo.add(txtMyName);

		JLabel lblNewLabel_4_1_1 = new JLabel("아이디");
		lblNewLabel_4_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4_1_1.setFont(new Font("휴먼모음T", Font.PLAIN, 20));
		lblNewLabel_4_1_1.setBounds(74, 247, 100, 40);
		paMyInfo.add(lblNewLabel_4_1_1);

		txtMyId = new JTextField();
		txtMyId.setColumns(10);
		txtMyId.setBounds(174, 247, 490, 40);
		paMyInfo.add(txtMyId);

		JLabel lblNewLabel_4_1_2 = new JLabel("비밀번호");
		lblNewLabel_4_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4_1_2.setFont(new Font("휴먼모음T", Font.PLAIN, 20));
		lblNewLabel_4_1_2.setBounds(74, 304, 100, 40);
		paMyInfo.add(lblNewLabel_4_1_2);

		txtMyPw = new JTextField();
		txtMyPw.setColumns(10);
		txtMyPw.setBounds(174, 304, 490, 40);
		paMyInfo.add(txtMyPw);

		JLabel lblNewLabel_4_1_3 = new JLabel("생년월일");
		lblNewLabel_4_1_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4_1_3.setFont(new Font("휴먼모음T", Font.PLAIN, 20));
		lblNewLabel_4_1_3.setBounds(74, 361, 100, 40);
		paMyInfo.add(lblNewLabel_4_1_3);

		txtBOD = new JTextField();
		txtBOD.setColumns(10);
		txtBOD.setBounds(174, 361, 490, 40);
		paMyInfo.add(txtBOD);

		JLabel lblNewLabel_4_1_4 = new JLabel("폰번호");
		lblNewLabel_4_1_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4_1_4.setFont(new Font("휴먼모음T", Font.PLAIN, 20));
		lblNewLabel_4_1_4.setBounds(74, 418, 100, 40);
		paMyInfo.add(lblNewLabel_4_1_4);

		txtPhoneNum = new JTextField();
		txtPhoneNum.setColumns(10);
		txtPhoneNum.setBounds(174, 418, 490, 40);
		paMyInfo.add(txtPhoneNum);

		JButton btnNewButton = new JButton("수정");
		btnNewButton.setFont(new Font("휴먼모음T", Font.PLAIN, 20));
		btnNewButton.setBounds(300, 540, 100, 40);
		paMyInfo.add(btnNewButton);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.ORANGE);
		panel_1.setBounds(0, 38, 738, 125);
		paMyInfo.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel_4 = new JLabel("회원정보");
		lblNewLabel_4.setForeground(new Color(254, 254, 255));
		lblNewLabel_4.setBounds(44, 44, 200, 47);
		panel_1.add(lblNewLabel_4);
		lblNewLabel_4.setFont(new Font("휴먼모음T", Font.PLAIN, 40));

		JButton btnNewButton_1 = new JButton("회원탈퇴");
		btnNewButton_1.setBounds(550, 44, 120, 40);
		panel_1.add(btnNewButton_1);
		btnNewButton_1.setFont(new Font("휴먼모음T", Font.PLAIN, 20));
		paMyInfo.setVisible(false);

		// ---축제등록---------------------------------------------------------------------------------------------------
		JPanel paBoothWrite = new JPanel();
		paBoothWrite.setBounds(270, 0, 738, 729);

		contentPane.add(paBoothWrite);
		paBoothWrite.setLayout(null);

		JLabel lblNewLabel_5 = new JLabel("축제 리스트");
		lblNewLabel_5.setFont(new Font("휴먼모음T", Font.PLAIN, 15));
		lblNewLabel_5.setBounds(33, 56, 120, 20);
		paBoothWrite.add(lblNewLabel_5);

		JLabel lblNewLabel_2 = new JLabel("부스유형");
		lblNewLabel_2.setFont(new Font("휴먼모음T", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(33, 246, 100, 20);
		paBoothWrite.add(lblNewLabel_2);

		JLabel lblNewLabel_2_1 = new JLabel("부스명");
		lblNewLabel_2_1.setFont(new Font("휴먼모음T", Font.PLAIN, 15));
		lblNewLabel_2_1.setBounds(33, 295, 100, 20);
		paBoothWrite.add(lblNewLabel_2_1);

		JLabel lblNewLabel_2_3 = new JLabel("시작시간");
		lblNewLabel_2_3.setFont(new Font("휴먼모음T", Font.PLAIN, 15));
		lblNewLabel_2_3.setBounds(33, 403, 120, 20);
		paBoothWrite.add(lblNewLabel_2_3);

		txtBoothName = new JTextField();
		txtBoothName.setColumns(10);
		txtBoothName.setBounds(145, 295, 485, 20);
		paBoothWrite.add(txtBoothName);

		txtBoothBegin = new JTextField();
		txtBoothBegin.setColumns(10);
		txtBoothBegin.setBounds(145, 403, 188, 20);
		paBoothWrite.add(txtBoothBegin);

		txtBoothMaxP = new JTextField();
		txtBoothMaxP.setColumns(10);
		txtBoothMaxP.setBounds(145, 344, 185, 20);
		paBoothWrite.add(txtBoothMaxP);

		JLabel lblNewLabel_2_2_1 = new JLabel("최대입장인원");
		lblNewLabel_2_2_1.setFont(new Font("휴먼모음T", Font.PLAIN, 15));
		lblNewLabel_2_2_1.setBounds(33, 344, 100, 20);
		paBoothWrite.add(lblNewLabel_2_2_1);

		JLabel lblNewLabel_2_3_1 = new JLabel("종료시간");
		lblNewLabel_2_3_1.setFont(new Font("휴먼모음T", Font.PLAIN, 15));
		lblNewLabel_2_3_1.setBounds(345, 403, 100, 20);
		paBoothWrite.add(lblNewLabel_2_3_1);

		txtBoothEnd = new JTextField();
		txtBoothEnd.setColumns(10);
		txtBoothEnd.setBounds(445, 403, 185, 20);
		paBoothWrite.add(txtBoothEnd);

		comBoothType_1 = new JComboBox();
		comBoothType_1.setModel(new DefaultComboBoxModel(new String[] { "식음료판매", "플리마켓", "주류판매", "체험/게임", "기타" }));
		comBoothType_1.setBounds(145, 246, 485, 20);
		paBoothWrite.add(comBoothType_1);
		paBoothWrite.setVisible(false);

		JLabel lblNewLabel_2_5 = new JLabel("부스내용");
		lblNewLabel_2_5.setFont(new Font("휴먼모음T", Font.PLAIN, 15));
		lblNewLabel_2_5.setBounds(33, 521, 100, 20);
		paBoothWrite.add(lblNewLabel_2_5);

		txtBoothContent = new JTextField();
		txtBoothContent.setColumns(10);
		txtBoothContent.setBounds(144, 461, 482, 141);
		paBoothWrite.add(txtBoothContent);

		JLabel lblNewLabel_2_2_1_1 = new JLabel("부스직책등급");
		lblNewLabel_2_2_1_1.setFont(new Font("휴먼모음T", Font.PLAIN, 15));
		lblNewLabel_2_2_1_1.setBounds(345, 344, 100, 20);
		paBoothWrite.add(lblNewLabel_2_2_1_1);

		comBoothRank = new JComboBox();
		comBoothRank.setModel(new DefaultComboBoxModel(new String[] { "부스 스태프", "부스 부매니저", "부스 매니저" }));
		comBoothRank.setBounds(445, 344, 185, 20);
		paBoothWrite.add(comBoothRank);

		JButton btnNewButton_2 = new JButton("등록");
		btnNewButton_2.setFont(new Font("휴먼모음T", Font.PLAIN, 15));

		// 부스 등록 버튼 활성화

		btnNewButton_2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				try {
					dao = new BoothWriteDAO();
					String type = (String) comBoothType_1.getSelectedItem();
					String name = txtBoothName.getText();
					int max = Integer.parseInt(txtBoothMaxP.getText());
					String begin = txtBoothBegin.getText();
					String end = txtBoothEnd.getText();
					String content = txtBoothContent.getText();
					String bmrankName = (String) comBoothRank.getSelectedItem();
					BoothWriteVO vo = new BoothWriteVO(type, festivalNo, max, name, begin, end, content, loginMemberId,
							bmrankName);

					dao.regist(vo);
					JOptionPane.showMessageDialog(null, "부스 등록을 완료했습니다.");
					selectBoothList();
					clearScreen();

				} catch (Exception e2) {
					e2.printStackTrace();
					// TODO: handle exception
					JOptionPane.showMessageDialog(null, e2.getMessage());
					System.out.println("부스 등록 실패");
				}

			}
		});

		btnNewButton_2.setBounds(309, 639, 145, 30);
		paBoothWrite.add(btnNewButton_2);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(0, 86, 738, 141);
		paBoothWrite.add(scrollPane_1);

		tblBoothFestivalList = new JTable();
		scrollPane_1.setViewportView(tblBoothFestivalList);
		paBoothWrite.setVisible(false);

		tblBoothFestivalList.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				int row = tblBoothFestivalList.getSelectedRow();
				int col = 0;
				festivalNo = (int) tblBoothFestivalList.getValueAt(row, col);

			}

		});

		boothModel = new ListTableBoothModel();
		selectBoothList();

		listTableModel = new ListTableModel();
		selectfestivalList();

		// 메뉴패널-----------------------------------------------------------------------------------------------------------
		JPanel paMenu = new JPanel();
		paMenu.setBackground(new Color(153, 51, 255));
		paMenu.setBounds(0, 0, 270, 729);
		contentPane.add(paMenu);
		paMenu.setLayout(null);

		JButton btnGetMyInfo = new JButton("내정보");
		btnGetMyInfo.setFont(new Font("휴먼모음T", Font.PLAIN, 20));
		btnGetMyInfo.setBounds(0, 142, 270, 46);
		paMenu.add(btnGetMyInfo);

		JButton btnGetBoothWrite = new JButton("부스등록");
		btnGetBoothWrite.setFont(new Font("휴먼모음T", Font.PLAIN, 20));

		btnGetBoothWrite.setBounds(0, 188, 270, 46);
		paMenu.add(btnGetBoothWrite);

		JButton btnGetBoothList = new JButton("부스리스트");
		btnGetBoothList.setFont(new Font("휴먼모음T", Font.PLAIN, 20));

		btnGetBoothList.setBounds(0, 234, 270, 46);
		paMenu.add(btnGetBoothList);

		JLabel lblNewLabel_1_1 = new JLabel("");
		lblNewLabel_1_1.setOpaque(true);
		lblNewLabel_1_1.setBackground(new Color(102, 51, 255));
		lblNewLabel_1_1.setBounds(0, 0, 270, 142);
		paMenu.add(lblNewLabel_1_1);

		listTableModel = new ListTableModel();
		selectfestivalList();
		paMenu.setVisible(true);

		btnGetBoothWrite.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				paBoothWrite.setVisible(true);
				paMyInfo.setVisible(false);
				paBoothList.setVisible(false);
				paMenu.setVisible(true);
			}
		});

		btnGetBoothList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				paBoothWrite.setVisible(false);
				paMyInfo.setVisible(false);
				paBoothList.setVisible(true);
				paMenu.setVisible(true);
			}
		});
		btnGetMyInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				paBoothWrite.setVisible(false);
				paMyInfo.setVisible(true);
				paBoothList.setVisible(false);
				paMenu.setVisible(true);
			}
		});

		tblBoothList.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = tblBoothList.getSelectedRow();
				int col = 0;
				System.out.println(tblBoothList.getValueAt(row, col));
				boothNo = (int) tblBoothList.getValueAt(row, col);
				// lblFestNo.setText(Integer.toString(festivalNo));
				// festNo = festivalNo;
				int col2 = 2;
				System.out.println(tblBoothList.getValueAt(row, col2));
				String boothName = (String) tblBoothList.getValueAt(row, col2);
				lblBoothName.setText(boothName);

				int col1 = 1;
				System.out.println(tblBoothList.getValueAt(row, col1));
				String festName = (String) tblBoothList.getValueAt(row, col1);
				lblFestName.setText(festName);
			}
		});

		// 관리페이지로 이동  
		btnGoToTab.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 꼭 boothNo 넘기기!!!!!!!!!!!!
				BoothProgramView BoothProgramView = new BoothProgramView(boothNo);
				///////////////////////////////
				BoothRevView BoothRevView = new BoothRevView(boothNo);
				BoothInventoryView BoothInventoryView = new BoothInventoryView(boothNo);

				tabbedPane.removeAll();
				tabbedPane.addTab("프로그램관리", BoothProgramView);
				tabbedPane.addTab("재고관리", BoothInventoryView);
				tabbedPane.addTab("예약관리", BoothRevView);

				paBoothmanager.setVisible(true);
				paBoothWrite.setVisible(false);
				paMyInfo.setVisible(false);
				paBoothList.setVisible(false);
				paMenu.setVisible(false);
			}
		});
		
		// 뒤로가기 
		btnGoToBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				paBoothWrite.setVisible(false);
				paMyInfo.setVisible(false);
				paBoothList.setVisible(true);
				paMenu.setVisible(true);
				paBoothmanager.setVisible(false);
			}
		});
		
		JLabel background = new JLabel("");
		background.setIcon(new ImageIcon(MemberBoothView.class.getResource("/img/background_2.jpeg")));
		background.setBounds(0, 0, 984, 657);
		getContentPane().add(background);

	}

	protected void clearScreen() {
		comBoothType_1.setSelectedItem("식음료판매");
		txtBoothName.setText("");
		txtBoothMaxP.setText("");
		txtBoothBegin.setText("");
		txtBoothEnd.setText("");
		txtBoothContent.setText("");
		comBoothRank.setSelectedItem("부스 매니저");

		
	}

	void selectfestivalList() {
		try {
			ArrayList list = dao.festivallist();
			listTableModel.data = list;
			tblBoothFestivalList.setModel(listTableModel);
			listTableModel.fireTableDataChanged();

		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	class ListTableModel extends AbstractTableModel {
		ArrayList data = new ArrayList();
		String[] colNames = { "축제번호", "축제유형", "축제명", "개최일", "마감일", "입장코드" };

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

	void selectBoothList() {
		System.out.println("selectBoothList");
		try {
			ArrayList list = boothSelectDAO.boothList();
			boothModel.data = list;
			tblBoothList.setModel(boothModel);
			boothModel.fireTableDataChanged();

		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	class ListTableBoothModel extends AbstractTableModel {
		ArrayList data = new ArrayList();
		String[] colNames = { "부스번호", "축제명", "부스명", "부스위치", "시작시간", "종료시간", "부스내용" };

		@Override
		public int getColumnCount() {
			// TODO Auto-generated method stub
			return colNames.length;
		}

		@Override
		public int getRowCount() {
			return data.size();
		}

		@Override
		public Object getValueAt(int rowIndex, int columnIndex) {
			ArrayList temp = (ArrayList) data.get(rowIndex);
			return temp.get(columnIndex);
		}

		public String getColumnName(int col) {
			return colNames[col];
		}

	}
}
