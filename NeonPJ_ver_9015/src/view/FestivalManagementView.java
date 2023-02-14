package view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.AbstractTableModel;

import model.FestivalInsertDAO;
import model.FestivalManagementDAO;
import model.JoinDAO;
import model.rec.FestivalInsertVO;
import model.rec.JoinVO;

import java.awt.event.*;
import java.util.ArrayList;
import java.awt.*;

public class FestivalManagementView extends JFrame {

	private festivalList tmFestivalList;
	private JPanel contentPane;
	private JFrame frame;
	private JTable table;
	private JTextField textFestivalName;
	private JTextField tfFestJuchName;
	private JTextField textFestivalStart;
	private JTextField textFestivalEnd;
	private JTable festivalTable;
	private JTextField textname;
	private JTextField textId;
	private JTextField textPass;
	private JTextField textBirth;
	private JTextField textPhone;
	FestivalManagementDAO dao = null;
	FestivalInsertDAO dao2 = null;
	private String fpublic = "YES";

	private int festivalNo;
	private String loginMemberId;
	private JTextField tfFestJugwName;
	private JTextField tfFestAddr;
	private JTextArea textFestivalContent;
	private JComboBox comMgrRank;

	/**
	 * Launch the application.
	 * 
	 * @wbp.parser.constructor
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					FestivalManagementView frame = new FestivalManagementView();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	public FestivalManagementView(int i, String loginMemberId) {
		FestivalManagementView frame = new FestivalManagementView(loginMemberId);
		frame.setVisible(true);
	}

	/**
	 * Create the frame.
	 */
	public FestivalManagementView(String loginMemberId) {
		this.loginMemberId = loginMemberId;

		try {
			dao = new FestivalManagementDAO(loginMemberId);
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

		JPanel paFestManager = new JPanel();
		paFestManager.setBounds(0, 0, 1008, 729);
		contentPane.add(paFestManager);
		paFestManager.setLayout(null);

		// add(writeView);

		FestivalBoothView festivalBoothView_1 = new FestivalBoothView(loginMemberId, festivalNo);
		FestivalPublicView festivalPublicView_1 = new FestivalPublicView(festivalNo);
		FestivalPerformanceView festivalPerformanceView_1 = new FestivalPerformanceView(festivalNo);
		// getContentPane();
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 67, 1008, 662);
		paFestManager.add(tabbedPane);

		tabbedPane.addTab("부스관리", festivalBoothView_1);
		tabbedPane.addTab("공연관리", festivalPerformanceView_1);
		tabbedPane.addTab("공공시설관리", festivalPublicView_1);

		JButton btnGoToBack = new JButton("뒤로가기");
		btnGoToBack.setFont(new Font("휴먼모음T", Font.PLAIN, 15));

		btnGoToBack.setBounds(870, 25, 100, 30);
		paFestManager.add(btnGoToBack);

		// 화면에 축제명, 관리자명 추가 (new)
		// ---------------------
		JLabel lblfestManagerName = new JLabel(loginMemberId);
		lblfestManagerName.setFont(new Font("휴먼모음T", Font.PLAIN, 20));
		lblfestManagerName.setBounds(680, 25, 150, 30);
		paFestManager.add(lblfestManagerName);

		JLabel lblfestName = new JLabel("축제명");
		lblfestName.setFont(new Font("휴먼모음T", Font.PLAIN, 25));
		lblfestName.setBounds(25, 25, 529, 30);
		paFestManager.add(lblfestName);
		// -----------------------------------------------------

		// 버튼
		// 이벤트---------------------------------------------------------------------------------------------------
		// festivalWrite.setVisible(true);
		paFestManager.setVisible(false);
		paFestManager.setVisible(false);
		// 뒤로가기 버튼

		// 뒤로가기

		// 축제리스트 패널
		JPanel paFestivalList = new JPanel();
		paFestivalList.setBounds(270, 0, 738, 729);
		contentPane.add(paFestivalList);
		paFestivalList.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 187, 738, 520);
		paFestivalList.add(scrollPane);
		festivalTable = new JTable(tmFestivalList);
		scrollPane.setViewportView(festivalTable);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.ORANGE);
		panel_1.setBounds(0, 38, 738, 125);
		paFestivalList.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel_3 = new JLabel("내 축제 리스트");
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setFont(new Font("휴먼모음T", Font.PLAIN, 22));
		lblNewLabel_3.setBounds(50, 50, 150, 40);
		panel_1.add(lblNewLabel_3);

		JButton btnGoToTab = new JButton("관리화면으로 이동");
		btnGoToTab.setFont(new Font("휴먼모음T", Font.PLAIN, 15));
		btnGoToTab.setBounds(530, 50, 170, 40);
		panel_1.add(btnGoToTab);
		// ---------------------------------------------------------------------------------------------------------------------

		paFestivalList.setVisible(false);

		// ---------------------------------------------------------------------------------------------------------------------
		paFestivalList.setVisible(true);

		// 축제리스트 클릭 후 관리화면 이동 활성화 (new)
		// ---------------------------------------------

		JPanel paMyInfo = new JPanel();
		paMyInfo.setBounds(270, 0, 738, 729);
		contentPane.add(paMyInfo);
		paMyInfo.setLayout(null);

		JLabel lbname = new JLabel("이름");
		lbname.setHorizontalAlignment(SwingConstants.CENTER);
		lbname.setFont(new Font("휴먼모음T", Font.PLAIN, 20));
		lbname.setBounds(74, 190, 100, 40);
		paMyInfo.add(lbname);

		textname = new JTextField();
		textname.setBounds(174, 190, 490, 40);
		paMyInfo.add(textname);
		textname.setColumns(10);

		JLabel lbId = new JLabel("아이디");
		lbId.setHorizontalAlignment(SwingConstants.CENTER);
		lbId.setFont(new Font("휴먼모음T", Font.PLAIN, 20));
		lbId.setBounds(74, 247, 100, 40);
		paMyInfo.add(lbId);

		textId = new JTextField();
		textId.setColumns(10);
		textId.setBounds(174, 247, 490, 40);
		paMyInfo.add(textId);

		JLabel lbPass = new JLabel("비밀번호");
		lbPass.setHorizontalAlignment(SwingConstants.CENTER);
		lbPass.setFont(new Font("휴먼모음T", Font.PLAIN, 20));
		lbPass.setBounds(74, 304, 100, 40);
		paMyInfo.add(lbPass);

		textPass = new JTextField();
		textPass.setColumns(10);
		textPass.setBounds(174, 304, 490, 40);
		paMyInfo.add(textPass);

		JLabel lbBirth = new JLabel("생년월일");
		lbBirth.setHorizontalAlignment(SwingConstants.CENTER);
		lbBirth.setFont(new Font("휴먼모음T", Font.PLAIN, 20));
		lbBirth.setBounds(74, 361, 100, 40);
		paMyInfo.add(lbBirth);

		textBirth = new JTextField();
		textBirth.setColumns(10);
		textBirth.setBounds(174, 361, 490, 40);
		paMyInfo.add(textBirth);

		JLabel lbPhone = new JLabel("폰번호");
		lbPhone.setHorizontalAlignment(SwingConstants.CENTER);
		lbPhone.setFont(new Font("휴먼모음T", Font.PLAIN, 20));
		lbPhone.setBounds(74, 418, 100, 40);
		paMyInfo.add(lbPhone);

		textPhone = new JTextField();
		textPhone.setColumns(10);
		textPhone.setBounds(174, 418, 490, 40);
		paMyInfo.add(textPhone);

		JButton btnMemModify = new JButton("수정");
		btnMemModify.setFont(new Font("휴먼모음T", Font.PLAIN, 20));
		btnMemModify.setBounds(300, 540, 100, 40);
		paMyInfo.add(btnMemModify);

		JPanel panel = new JPanel();
		panel.setBackground(Color.ORANGE);
		panel.setBounds(0, 38, 738, 125);
		paMyInfo.add(panel);
		panel.setLayout(null);

		JLabel lbmemberinfo = new JLabel("회원정보");
		lbmemberinfo.setForeground(new Color(255, 255, 255));
		lbmemberinfo.setBounds(44, 44, 200, 47);
		panel.add(lbmemberinfo);
		lbmemberinfo.setFont(new Font("휴먼모음T", Font.PLAIN, 40));

		JButton btnMemDelete = new JButton("회원탈퇴");
		btnMemDelete.setBounds(550, 44, 120, 40);
		panel.add(btnMemDelete);
		btnMemDelete.setFont(new Font("휴먼모음T", Font.PLAIN, 20));
		paMyInfo.setVisible(false);

		// ---축제등록---------------------------------------------------------------------------------------------------
		JPanel paFestivalWrite = new JPanel();
		paFestivalWrite.setBounds(270, 0, 738, 729);

		contentPane.add(paFestivalWrite);
		paFestivalWrite.setLayout(null);

		JLabel lblNewLabel_2 = new JLabel("축제유형");
		lblNewLabel_2.setFont(new Font("휴먼모음T", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(33, 84, 100, 20);
		paFestivalWrite.add(lblNewLabel_2);

		JLabel lblNewLabel_2_1 = new JLabel("축제명");
		lblNewLabel_2_1.setFont(new Font("휴먼모음T", Font.PLAIN, 15));
		lblNewLabel_2_1.setBounds(33, 139, 100, 20);
		paFestivalWrite.add(lblNewLabel_2_1);

		JLabel lblNewLabel_2_2 = new JLabel("주최사명");
		lblNewLabel_2_2.setFont(new Font("휴먼모음T", Font.PLAIN, 15));
		lblNewLabel_2_2.setBounds(265, 250, 67, 30);
		paFestivalWrite.add(lblNewLabel_2_2);

		JLabel lblNewLabel_2_3 = new JLabel("개최일");
		lblNewLabel_2_3.setFont(new Font("휴먼모음T", Font.PLAIN, 15));
		lblNewLabel_2_3.setBounds(33, 305, 100, 30);
		paFestivalWrite.add(lblNewLabel_2_3);

		JLabel lblNewLabel_2_4 = new JLabel("마감일");
		lblNewLabel_2_4.setFont(new Font("휴먼모음T", Font.PLAIN, 15));
		lblNewLabel_2_4.setBounds(33, 355, 100, 30);
		paFestivalWrite.add(lblNewLabel_2_4);

		JLabel lblNewLabel_2_5 = new JLabel("축제내용");
		lblNewLabel_2_5.setFont(new Font("휴먼모음T", Font.PLAIN, 15));
		lblNewLabel_2_5.setBounds(33, 460, 100, 30);
		paFestivalWrite.add(lblNewLabel_2_5);

		JComboBox comFestivalType = new JComboBox();
		comFestivalType.setModel(new DefaultComboBoxModel(new String[] { "선택", "대학교축제", "야시장", "박람회" }));
		comFestivalType.setBounds(144, 80, 402, 30);
		paFestivalWrite.add(comFestivalType);

		textFestivalName = new JTextField();
		textFestivalName.setColumns(10);
		textFestivalName.setBounds(144, 136, 486, 30);
		paFestivalWrite.add(textFestivalName);

		tfFestJuchName = new JTextField();
		tfFestJuchName.setColumns(10);
		tfFestJuchName.setBounds(330, 250, 105, 30);
		paFestivalWrite.add(tfFestJuchName);

		textFestivalStart = new JTextField();
		textFestivalStart.setColumns(10);
		textFestivalStart.setBounds(144, 305, 486, 30);
		paFestivalWrite.add(textFestivalStart);

		textFestivalEnd = new JTextField();
		textFestivalEnd.setColumns(10);
		textFestivalEnd.setBounds(144, 355, 486, 30);
		paFestivalWrite.add(textFestivalEnd);

		textFestivalContent = new JTextArea();
		textFestivalContent.setBounds(144, 406, 486, 141);
		paFestivalWrite.add(textFestivalContent);

		JCheckBox chBoxFestivalPublic = new JCheckBox("비공개");
		chBoxFestivalPublic.setFont(new Font("휴먼모음T", Font.PLAIN, 15));
		chBoxFestivalPublic.setBounds(563, 80, 90, 30);
		paFestivalWrite.add(chBoxFestivalPublic);

		JButton btnFestivalInsert = new JButton("등록");
		btnFestivalInsert.setBounds(310, 585, 120, 30);
		paFestivalWrite.add(btnFestivalInsert);

		tfFestJugwName = new JTextField();
		tfFestJugwName.setColumns(10);
		tfFestJugwName.setBounds(144, 250, 109, 30);
		paFestivalWrite.add(tfFestJugwName);

		JLabel lblNewLabel_2_3_1 = new JLabel("주관사명");
		lblNewLabel_2_3_1.setFont(new Font("휴먼모음T", Font.PLAIN, 15));
		lblNewLabel_2_3_1.setBounds(33, 250, 100, 30);
		paFestivalWrite.add(lblNewLabel_2_3_1);

		tfFestAddr = new JTextField();
		tfFestAddr.setColumns(10);
		tfFestAddr.setBounds(144, 194, 486, 30);
		paFestivalWrite.add(tfFestAddr);

		JLabel lblNewLabel_2_2_1 = new JLabel("개최장소");
		lblNewLabel_2_2_1.setFont(new Font("휴먼모음T", Font.PLAIN, 15));
		lblNewLabel_2_2_1.setBounds(33, 202, 100, 20);
		paFestivalWrite.add(lblNewLabel_2_2_1);

		JLabel lblNewLabel_2_2_2 = new JLabel("직책");
		lblNewLabel_2_2_2.setFont(new Font("휴먼모음T", Font.PLAIN, 15));
		lblNewLabel_2_2_2.setBounds(448, 252, 41, 30);
		paFestivalWrite.add(lblNewLabel_2_2_2);

		comMgrRank = new JComboBox();

		comMgrRank.setModel(new DefaultComboBoxModel(new String[] { "선택", "축제 스태프", "축제 부매니저", "축제 매니저" }));
		comMgrRank.setBounds(490, 250, 140, 30);
		paFestivalWrite.add(comMgrRank);
		paFestivalWrite.setVisible(false);

		// 메뉴패널-----------------------------------------------------------------------------------------------------------
		JPanel paMenu = new JPanel();
		paMenu.setBackground(new Color(153, 51, 255));
		paMenu.setBounds(0, 0, 270, 729);
		contentPane.add(paMenu);
		paMenu.setLayout(null);

		JButton btnGetMyInfo = new JButton("내정보");
		btnGetMyInfo.setFont(new Font("휴먼모음T", Font.PLAIN, 20));
		btnGetMyInfo.setBackground(new Color(153, 51, 255));
		btnGetMyInfo.setBounds(0, 142, 270, 46);
		paMenu.add(btnGetMyInfo);

		JButton btnGetFestWrite = new JButton("축제등록");
		btnGetFestWrite.setFont(new Font("휴먼모음T", Font.PLAIN, 20));
		btnGetFestWrite.setBackground(new Color(153, 51, 255));

		btnGetFestWrite.setBounds(0, 188, 270, 46);
		paMenu.add(btnGetFestWrite);

		JButton btnGetFestList = new JButton("축제리스트");
		btnGetFestList.setFont(new Font("휴먼모음T", Font.PLAIN, 20));
		btnGetFestList.setBackground(new Color(153, 51, 255));

		btnGetFestList.setBounds(0, 234, 270, 46);
		paMenu.add(btnGetFestList);

		JLabel lbLogo = new JLabel("");
		lbLogo.setBackground(new Color(102, 51, 255));
		lbLogo.setBounds(0, 0, 270, 142);
		paMenu.add(lbLogo);
		lbLogo.setOpaque(true);

		tmFestivalList = new festivalList();
		sreachFestival();
		paMenu.setVisible(true);
		// 축제작성창 이동
		btnGetFestWrite.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				paFestivalWrite.setVisible(true);
				paFestivalList.setVisible(false);
				paMenu.setVisible(true);
				paMyInfo.setVisible(false);
			}
		});
		// 축제리스트창 이동
		btnGetFestList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				paFestivalWrite.setVisible(false);
				paFestivalList.setVisible(true);
				paMenu.setVisible(true);
				paMyInfo.setVisible(false);
			}
		});

		// 내정보창 이동
		btnGetMyInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				paFestivalWrite.setVisible(false);
				paFestivalList.setVisible(false);
				paMenu.setVisible(true);
				paMyInfo.setVisible(true);
			}
		});

		// 축제 비공개체크박스 입력
		chBoxFestivalPublic.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					fpublic = "NO";
				}
			}
		});

		// 축제 하나를 선택
		festivalTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				int row = festivalTable.getSelectedRow();
				int col = 0;
				System.out.println(festivalTable.getValueAt(row, col));
				festivalNo = (int) festivalTable.getValueAt(row, col);

				int col2 = 3;
				System.out.println(festivalTable.getValueAt(row, col2));
				String festName = (String) festivalTable.getValueAt(row, col2);
				lblfestName.setText(festName);

				
			}
		});

		// 축제 관리화면 이동
		btnGoToTab.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FestivalBoothView festivalBoothView = new FestivalBoothView(loginMemberId, festivalNo);
				FestivalPerformanceView festivalPerformanceView = new FestivalPerformanceView(festivalNo);
				FestivalPublicView festivalPublicView = new FestivalPublicView(festivalNo);

				tabbedPane.removeAll();
				tabbedPane.addTab("부스관리", festivalBoothView);
				tabbedPane.addTab("공연관리", festivalPerformanceView);
				tabbedPane.addTab("공공시설관리", festivalPublicView);

				paFestManager.setVisible(true);
				paFestivalWrite.setVisible(false);
				paMyInfo.setVisible(false);
				paFestivalList.setVisible(false);
				paMenu.setVisible(false);
			}
		});

		// 축제 인서트버튼
		btnFestivalInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

					dao2 = new FestivalInsertDAO();
					String type = (String) comFestivalType.getSelectedItem();

					String name = textFestivalName.getText();
					String start = textFestivalStart.getText();
					String end = textFestivalEnd.getText();
					String content = textFestivalContent.getText();
					String addr = tfFestAddr.getText();
					String jugw = tfFestJugwName.getText();
					String juch = tfFestJuchName.getText();
					String mgrRank = (String) comMgrRank.getSelectedItem();

					FestivalInsertVO vo = new FestivalInsertVO(type, fpublic, name, start, end, content, addr, jugw,
							juch, mgrRank);

					dao2.regist(vo, loginMemberId);
					sreachFestival();
					JOptionPane.showMessageDialog(null, "축제가 등록되었습니다");
					clearScreen();
				} catch (Exception e1) {
					e1.printStackTrace();
					// TODO: handle exception
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
			}
		});

		btnGoToBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				paFestivalWrite.setVisible(false);
				paFestivalList.setVisible(true);
				paMenu.setVisible(true);
				paMyInfo.setVisible(false);
				paFestManager.setVisible(false);

			}
		});

		JLabel background = new JLabel("");
		background.setIcon(new ImageIcon(MemberBoothView.class.getResource("/img/background_2.jpeg")));
		background.setBounds(0, 0, 984, 657);
		getContentPane().add(background);

	}

	protected void clearScreen() {
		textFestivalName.setText("");
		textFestivalStart.setText("");
		textFestivalEnd.setText("");
		textFestivalContent.setText("");
		tfFestAddr.setText("");
		tfFestJugwName.setText("");
		tfFestJuchName.setText("");
		comMgrRank.setSelectedItem("축제 매니저");
		
	}

	// 축제리스트내용 추가메서드
	void sreachFestival() {
		try {
			ArrayList list = dao.festivalsearchList();
			tmFestivalList.data = list;
			festivalTable.setModel(tmFestivalList);
			tmFestivalList.fireTableDataChanged();
		} catch (Exception e2) {
			// TODO: handle exception
			e2.printStackTrace();
		}
	}

	// 축제리스트 클래스
	class festivalList extends AbstractTableModel {

		ArrayList data = new ArrayList();
		String[] columnNames = { "축제번호", "축제유형", "공개여부", "축제명", "축제내용", "축제개최일", "축제마감일" };

		@Override
		public int getRowCount() {
			// TODO Auto-generated method stub

			return data.size();
		}

		@Override
		public int getColumnCount() {
			// TODO Auto-generated method stub
			return columnNames.length;
		}

		@Override
		public Object getValueAt(int row, int col) {
			// TODO Auto-generated method stub
			ArrayList temp = (ArrayList) data.get(row);
			return temp.get(col);
		}

		public String getColumnName(int col) {
			return columnNames[col];
		}

	}
}
