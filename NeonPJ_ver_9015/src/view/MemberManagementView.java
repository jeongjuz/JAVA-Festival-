package view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.util.ArrayList;
import java.awt.*;
import javax.swing.border.LineBorder;
import javax.swing.table.AbstractTableModel;

import model.MemberInfoDAO;
import model.MemberManagementDAO;
import model.rec.MemberInfoVO;

public class MemberManagementView extends JFrame {

	private JPanel contentPane;
	private ListTableModel listTableModel;
	private MemberManagementDAO managementDAO;
	private MemberInfoDAO memberInfoDAO;
	private JTable tbfestivallist;
	private JTextField textName;
	private JTextField textID;
	private JTextField textPW;
	private JTextField textBirth;
	private JTextField textPhone;
	private JTextField textField_5;
	private JTable table_2;
	private int festNo;
	private String loginMemberId;

	MemberBoothView memberBoothView;
	MemberPerformanceView memberPerformanceView;
	MemberRevView memberRevView;
	MemberPublicView memberPublicView;
	MemberPostManagement memberPost;
	MemberInfoVO memberInfoVO;

	public String getLoginMemberId() {
		return loginMemberId;
	}

	public void setLoginMemberId(String loginMemberId) {
		this.loginMemberId = loginMemberId;
	}

	public MemberManagementView(String loginMemberId) {
		setVisible(true);
		// 로그인 아이디 세팅
		this.loginMemberId = loginMemberId;

		try {
			managementDAO = new MemberManagementDAO();
			memberInfoDAO = new MemberInfoDAO();
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

		JPanel pamembermanager = new JPanel();
		pamembermanager.setBounds(0, 0, 1008, 729);
		contentPane.add(pamembermanager);
		pamembermanager.setLayout(null);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 67, 1008, 662);
		pamembermanager.add(tabbedPane);

		JButton btnGoToBack = new JButton("뒤로가기");
		btnGoToBack.setFont(new Font("휴먼모음T", Font.PLAIN, 15));

		btnGoToBack.setBounds(870, 25, 100, 30);
		pamembermanager.add(btnGoToBack);

		JLabel lbMemberName = new JLabel(loginMemberId);
		lbMemberName.setFont(new Font("휴먼모음T", Font.PLAIN, 20));
		lbMemberName.setBounds(680, 25, 150, 30);
		pamembermanager.add(lbMemberName);

		JLabel lblfestivalname = new JLabel("축제명");
		lblfestivalname.setFont(new Font("휴먼모음T", Font.PLAIN, 22));
		lblfestivalname.setBounds(25, 25, 200, 30);
		pamembermanager.add(lblfestivalname);

		JLabel lblFestNo = new JLabel("축제번호");
		lblFestNo.setFont(new Font("굴림", Font.PLAIN, 5));
		lblFestNo.setBounds(275, 25, 200, 30);
		lblFestNo.setVisible(false);
		pamembermanager.add(lblFestNo);

		// 버튼
		// 이벤트---------------------------------------------------------------------------------------------------
		pamembermanager.setVisible(false);

		// 축제리스트 패널
		JPanel paFestivalList = new JPanel();
		paFestivalList.setBounds(270, 0, 738, 729);
		contentPane.add(paFestivalList);
		paFestivalList.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 187, 738, 520);
		paFestivalList.add(scrollPane);

		tbfestivallist = new JTable();
		scrollPane.setViewportView(tbfestivallist);

		JPanel panel = new JPanel();
		panel.setBackground(Color.ORANGE);
		panel.setBounds(0, 38, 738, 125);
		paFestivalList.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel_3 = new JLabel("축제리스트");
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setFont(new Font("휴먼모음T", Font.PLAIN, 22));
		lblNewLabel_3.setBounds(50, 50, 150, 40);
		panel.add(lblNewLabel_3);

		JButton btnGoToTab = new JButton("관리화면으로 이동");
		btnGoToTab.setFont(new Font("휴먼모음T", Font.PLAIN, 15));
		btnGoToTab.setBounds(530, 50, 170, 40);
		panel.add(btnGoToTab);

		paFestivalList.setVisible(false);
		paFestivalList.setVisible(true);

		// 관리화면 이동

		JPanel paMywriteList = new JPanel();
		paMywriteList.setBounds(270, 0, 738, 729);
		contentPane.add(paMywriteList);
		paMywriteList.setLayout(null);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(0, 134, 738, 461);
		paMywriteList.add(scrollPane_1);

		table_2 = new JTable();
		table_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		scrollPane_1.setViewportView(table_2);

		textField_5 = new JTextField();
		textField_5.setBounds(0, 84, 738, 40);
		paMywriteList.add(textField_5);
		textField_5.setColumns(10);

		JButton btnNewButton_2 = new JButton("조회");
		btnNewButton_2.setFont(new Font("휴먼모음T", Font.PLAIN, 20));
		btnNewButton_2.setBounds(300, 640, 100, 40);
		paMywriteList.add(btnNewButton_2);
		paMywriteList.setVisible(false);

		JPanel paMyInfo = new JPanel();
		paMyInfo.setLayout(null);
		paMyInfo.setBounds(270, 0, 738, 729);
		contentPane.add(paMyInfo);

		JLabel lblNewLabel_4_1 = new JLabel("이름");
		lblNewLabel_4_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4_1.setFont(new Font("휴먼모음T", Font.PLAIN, 20));
		lblNewLabel_4_1.setBounds(74, 190, 100, 40);
		paMyInfo.add(lblNewLabel_4_1);

		textName = new JTextField();

		textName.setColumns(10);
		textName.setBounds(174, 190, 490, 40);
		paMyInfo.add(textName);

		JLabel lblNewLabel_4_1_1 = new JLabel("아이디");
		lblNewLabel_4_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4_1_1.setFont(new Font("휴먼모음T", Font.PLAIN, 20));
		lblNewLabel_4_1_1.setBounds(74, 247, 100, 40);
		paMyInfo.add(lblNewLabel_4_1_1);

		textID = new JTextField();
		textID.setColumns(10);
		textID.setBounds(174, 247, 490, 40);
		paMyInfo.add(textID);

		JLabel lblNewLabel_4_1_2 = new JLabel("비밀번호");
		lblNewLabel_4_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4_1_2.setFont(new Font("휴먼모음T", Font.PLAIN, 20));
		lblNewLabel_4_1_2.setBounds(74, 304, 100, 40);
		paMyInfo.add(lblNewLabel_4_1_2);

		textPW = new JTextField();
		textPW.setColumns(10);
		textPW.setBounds(174, 304, 490, 40);
		paMyInfo.add(textPW);

		JLabel lblNewLabel_4_1_3 = new JLabel("생년월일");
		lblNewLabel_4_1_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4_1_3.setFont(new Font("휴먼모음T", Font.PLAIN, 20));
		lblNewLabel_4_1_3.setBounds(74, 361, 100, 40);
		paMyInfo.add(lblNewLabel_4_1_3);

		textBirth = new JTextField();
		textBirth.setColumns(10);
		textBirth.setBounds(174, 361, 490, 40);
		paMyInfo.add(textBirth);

		JLabel lblNewLabel_4_1_4 = new JLabel("폰번호");
		lblNewLabel_4_1_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4_1_4.setFont(new Font("휴먼모음T", Font.PLAIN, 20));
		lblNewLabel_4_1_4.setBounds(74, 418, 100, 40);
		paMyInfo.add(lblNewLabel_4_1_4);

		textPhone = new JTextField();
		textPhone.setColumns(10);
		textPhone.setBounds(174, 418, 490, 40);
		paMyInfo.add(textPhone);

		JButton btnUpdateMember = new JButton("수정");
		btnUpdateMember.setFont(new Font("휴먼모음T", Font.PLAIN, 20));
		btnUpdateMember.setBounds(300, 540, 100, 40);
		paMyInfo.add(btnUpdateMember);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.ORANGE);
		panel_1.setBounds(0, 38, 738, 125);
		paMyInfo.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel_4 = new JLabel("회원정보");
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setBounds(44, 44, 200, 47);
		panel_1.add(lblNewLabel_4);
		lblNewLabel_4.setFont(new Font("휴먼모음T", Font.PLAIN, 40));

		JButton btnDeleteMember = new JButton("회원탈퇴");
		btnDeleteMember.setBounds(550, 44, 120, 40);
		panel_1.add(btnDeleteMember);
		btnDeleteMember.setFont(new Font("휴먼모음T", Font.PLAIN, 20));
		// 회원탈퇴 버튼
		btnDeleteMember.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		paMyInfo.setVisible(false);
		// 내정보 수정버튼
		btnUpdateMember.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});

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

		JButton btnGetFestWrite = new JButton("내가 쓴글");
		btnGetFestWrite.setFont(new Font("휴먼모음T", Font.PLAIN, 20));

		btnGetFestWrite.setBounds(0, 188, 270, 46);
		paMenu.add(btnGetFestWrite);

		JButton btnGetFestList = new JButton("축제리스트");
		btnGetFestList.setFont(new Font("휴먼모음T", Font.PLAIN, 20));

		btnGetFestList.setBounds(0, 234, 270, 46);
		paMenu.add(btnGetFestList);

		JLabel lblNewLabel_1_1 = new JLabel("");
		lblNewLabel_1_1.setOpaque(true);
		lblNewLabel_1_1.setBackground(new Color(102, 51, 255));
		lblNewLabel_1_1.setBounds(0, 0, 270, 142);
		paMenu.add(lblNewLabel_1_1);
		paMenu.setVisible(true);

		try {
			MemberInfoVO vo = memberInfoDAO.MemberSearch(loginMemberId);
			setMyInfo(vo);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		listTableModel = new ListTableModel();
		selectfestivalList();

		// 뒤로가기
		btnGoToBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				paMyInfo.setVisible(false);
				paFestivalList.setVisible(true);
				paMenu.setVisible(true);
				pamembermanager.setVisible(false);
			}
		});
		

		btnGetFestWrite.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				paFestivalList.setVisible(false);
				paMyInfo.setVisible(false);
				paMywriteList.setVisible(true);
				paMenu.setVisible(true);

			}
		});

		btnGetFestList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				paFestivalList.setVisible(true);
				paMyInfo.setVisible(false);
				paMywriteList.setVisible(false);
				paMenu.setVisible(true);
			}
		});

		btnGetMyInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				paFestivalList.setVisible(false);
				paMyInfo.setVisible(true);
				paMywriteList.setVisible(false);
				paMenu.setVisible(true);
			}

		});

		// 축제 하나를 선택 
		tbfestivallist.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {

				int row = tbfestivallist.getSelectedRow();
				int col = 0;
				System.out.println(tbfestivallist.getValueAt(row, col));
				int festivalNo = (int) tbfestivallist.getValueAt(row, col);
				lblFestNo.setText(Integer.toString(festivalNo));
				festNo = festivalNo;
				int col1=2;
				System.out.println(tbfestivallist.getValueAt(row, col));
				String festivalname = (String) tbfestivallist.getValueAt(row, col1);
				lblfestivalname.setText(festivalname);			
				
			}
			
		});
		
		// 관리페이지 이동 
		btnGoToTab.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				memberRevView = new MemberRevView(festNo, loginMemberId);
				memberPublicView = new MemberPublicView(festNo);
				memberBoothView = new MemberBoothView(festNo, loginMemberId, memberRevView);
				memberPerformanceView= new MemberPerformanceView(festNo);
				memberPost = new MemberPostManagement(loginMemberId, festNo);
				tabbedPane.removeAll();
				tabbedPane.addTab("내 예약", memberRevView);
				tabbedPane.addTab("부스", memberBoothView);
				tabbedPane.addTab("공연", memberPerformanceView);
				tabbedPane.addTab("공공시설", memberPublicView);
				tabbedPane.addTab("게시판", memberPost);
				
				// 탭팬 띄우기 
				paFestivalList.setVisible(false);
				paMenu.setVisible(false);
				pamembermanager.setVisible(true);
				paMyInfo.setVisible(false);
				paMywriteList.setVisible(false);
			}
		});
		
		// 배경색상 설정 
		JLabel background = new JLabel("");
		background.setIcon(new ImageIcon(MemberBoothView.class.getResource("/img/background_2.jpeg")));
		background.setBounds(0, 0, 984, 657);
		getContentPane().add(background);
	}

	void setMyInfo(MemberInfoVO vo) {
		textName.setText(vo.getName());
		textID.setText(vo.getId());
		textPW.setText(vo.getPw());
		textBirth.setText(vo.getBirth());
		textPhone.setText(vo.getPhone());
	}

	void selectfestivalList() {
		try {
			ArrayList list = managementDAO.festivallist();
			listTableModel.data = list;
			tbfestivallist.setModel(listTableModel);
			listTableModel.fireTableDataChanged();

		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	// 테이블 모델 클래스
	class ListTableModel extends AbstractTableModel {
		ArrayList data = new ArrayList();
		String[] colNames = { "축제번호", "축제유형", "축제명", "개최일", "마감일", "입장코드" };

		@Override
		public int getColumnCount() {
			// TODO colNamesAuto-generated method stub
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
