package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
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
import javax.swing.border.LineBorder;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

import model.FestivalBoothDAO;
import model.FestivalManagementDAO;
import model.rec.BoothProgramVO;
import model.rec.FestivalBoothVO;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;

public class FestivalBoothView extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField tfFBName;
	private JTextField tfFBLoc;
	private JTextField tfFBMax;
	private JTextField tfFBStart;
	private JTextField textField_7;
	private JTable table;

	private JTextField Boosearch;

	FestivalManagementDAO dao;
	FestivalBoothDAO dao2;
	private JTextField tfFBEnd;
	private ListTableModel listTableModel;
	private JTable FBotable;

	private JComboBox Boocombox;
	private String loginMemberId;
	private int festNo;
	private JComboBox comMgrRank;
	private JComboBox comFBType;
	private JTextArea taFBContent;
	

	/**
	 * Create the panel.
	 * 
	 * @throws Exception
	 */
	public FestivalBoothView(String loginMemberId, int festNo) {
		setForeground(new Color(179, 179, 179));
		this.loginMemberId = loginMemberId;
		this.festNo = festNo;

		try {
			dao2 = new FestivalBoothDAO(loginMemberId, festNo);
			System.out.println(loginMemberId);
			System.out.println(festNo);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			dao = new FestivalManagementDAO("");
			System.out.println("성공적으로 로딩되었음");
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "DB 연결 실패 : " + e.getMessage());
		}
		setLayout(null);
		setBounds(12, 62, 984, 657);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(522, 121, 417, 488);
		add(scrollPane);

		FBotable = new JTable();
		FBotable.setFont(new Font("\uD55C\uCEF4 \uACE0\uB515", FBotable.getFont().getStyle(), FBotable.getFont().getSize()));
		scrollPane.setViewportView(FBotable);
		FBotable.setModel(new DefaultTableModel(
				new Object[][] { { null, null, null, null, null, null }, { null, null, null, null, null, null },
						{ null, null, null, null, null, null }, { null, null, null, null, null, null },
						{ null, null, null, null, null, null }, },
				new String[] { "\uBD80\uC2A4\uC720\uD615", "\uBD80\uC2A4\uBA85", "\uBD80\uC2A4\uC704\uCE58",
						"\uCD5C\uB300\uC778\uC6D0", "\uC2DC\uC791\uC2DC\uAC04", "\uC885\uB8CC\uC2DC\uAC04" }));
		FBotable.setBorder(new LineBorder(new Color(0, 0, 0)));

		JLabel lblNewLabel = new JLabel("부스유형");
		lblNewLabel.setForeground(new Color(250, 255, 248));
		lblNewLabel.setFont(new Font("\uD55C\uCEF4 \uACE0\uB515", lblNewLabel.getFont().getStyle(), 20));
		lblNewLabel.setBounds(46, 34, 83, 30);
		add(lblNewLabel);

		comFBType = new JComboBox();
		comFBType.setFont(new Font("\uD55C\uCEF4 \uACE0\uB515", comFBType.getFont().getStyle(), 14));
		comFBType.setModel(new DefaultComboBoxModel(new String[] { "식음료판매", "플리마켓", "주류판매", "체험/게임", "기타" }));
		comFBType.setBounds(134, 35, 130, 30);
		add(comFBType);

		JLabel lblNewLabel_1 = new JLabel("부스명");
		lblNewLabel_1.setForeground(new Color(250, 255, 248));
		lblNewLabel_1.setFont(new Font("\uD55C\uCEF4 \uACE0\uB515", lblNewLabel.getFont().getStyle(), 20));
		lblNewLabel_1.setBounds(46, 89, 83, 24);
		add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("부스위치");
		lblNewLabel_1_1.setForeground(new Color(250, 255, 248));
		lblNewLabel_1_1.setFont(new Font("\uD55C\uCEF4 \uACE0\uB515", lblNewLabel.getFont().getStyle(), 20));
		lblNewLabel_1_1.setBounds(46, 144, 83, 24);
		add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_1_1 = new JLabel("최대인원");
		lblNewLabel_1_1_1.setForeground(new Color(250, 255, 248));
		lblNewLabel_1_1_1.setFont(new Font("\uD55C\uCEF4 \uACE0\uB515", lblNewLabel.getFont().getStyle(), 20));
		lblNewLabel_1_1_1.setBounds(46, 199, 77, 24);
		add(lblNewLabel_1_1_1);

		JLabel lblNewLabel_1_1_2 = new JLabel("시작시간");
		lblNewLabel_1_1_2.setForeground(new Color(250, 255, 248));
		lblNewLabel_1_1_2.setFont(new Font("\uD55C\uCEF4 \uACE0\uB515", lblNewLabel.getFont().getStyle(), 20));
		lblNewLabel_1_1_2.setBounds(46, 254, 83, 24);
		add(lblNewLabel_1_1_2);

		JLabel lbFBEnd = new JLabel("종료시간");
		lbFBEnd.setForeground(new Color(250, 255, 248));
		lbFBEnd.setFont(new Font("\uD55C\uCEF4 \uACE0\uB515", lblNewLabel.getFont().getStyle(), 20));
		lbFBEnd.setBounds(46, 309, 83, 24);
		add(lbFBEnd);

		JLabel lblNewLabel_1_1_2_1_1 = new JLabel("부스내용");
		lblNewLabel_1_1_2_1_1.setForeground(new Color(250, 255, 248));
		lblNewLabel_1_1_2_1_1.setFont(new Font("\uD55C\uCEF4 \uACE0\uB515", lblNewLabel.getFont().getStyle(), 20));
		lblNewLabel_1_1_2_1_1.setBounds(46, 362, 83, 24);
		add(lblNewLabel_1_1_2_1_1);

		tfFBName = new JTextField();
		tfFBName.setFont(new Font("\uD55C\uCEF4 \uACE0\uB515", tfFBName.getFont().getStyle(), 14));
		tfFBName.setColumns(10);
		tfFBName.setBounds(134, 90, 331, 24);
		add(tfFBName);

		tfFBLoc = new JTextField();
		tfFBLoc.setFont(new Font("\uD55C\uCEF4 \uACE0\uB515", tfFBLoc.getFont().getStyle(), 14));
		tfFBLoc.setColumns(10);
		tfFBLoc.setBounds(134, 145, 331, 24);
		add(tfFBLoc);

		tfFBMax = new JTextField();
		tfFBMax.setFont(new Font("\uD55C\uCEF4 \uACE0\uB515", tfFBMax.getFont().getStyle(), 14));
		tfFBMax.setColumns(10);
		tfFBMax.setBounds(134, 200, 331, 24);
		add(tfFBMax);

		tfFBStart = new JTextField();
		tfFBStart.setFont(new Font("\uD55C\uCEF4 \uACE0\uB515", tfFBStart.getFont().getStyle(), 14));
		tfFBStart.setColumns(10);
		tfFBStart.setBounds(134, 255, 331, 24);
		add(tfFBStart);

		tfFBEnd = new JTextField();
		tfFBEnd.setFont(new Font("\uD55C\uCEF4 \uACE0\uB515", tfFBEnd.getFont().getStyle(), 14));
		tfFBEnd.setColumns(10);
		tfFBEnd.setBounds(134, 310, 331, 24);
		add(tfFBEnd);

		taFBContent = new JTextArea();
		taFBContent.setFont(new Font("\uD55C\uCEF4 \uACE0\uB515", taFBContent.getFont().getStyle(), 14));
		taFBContent.setBounds(134, 365, 331, 174);
		add(taFBContent);

		Boosearch = new JTextField();
		Boosearch.setFont(new Font("\uD55C\uCEF4 \uACE0\uB515", Boosearch.getFont().getStyle(), 16));
		Boosearch.setToolTipText("");
		Boosearch.setBounds(522, 70, 417, 40);
		add(Boosearch);
		Boosearch.setColumns(10);

		JButton btnFestBoothRegist = new JButton("등록");
		btnFestBoothRegist.setFont(new Font("\uD55C\uCEF4 \uACE0\uB515", btnFestBoothRegist.getFont().getStyle(), 20));
		btnFestBoothRegist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String boothtype = (String) comFBType.getSelectedItem();
				String boothname = tfFBName.getText();
				String boothlocation = tfFBLoc.getText();
				String boothstart = tfFBStart.getText();
				String boothend = tfFBEnd.getText();
				String boothcontent = taFBContent.getText();
				int boothmax = Integer.parseInt(tfFBMax.getText());
				String mgrRank = (String) comMgrRank.getSelectedItem();

				FestivalBoothVO vo = new FestivalBoothVO(boothtype, boothname, boothlocation, boothstart, boothend,
						boothcontent, boothmax, mgrRank);
				try {
					dao2.FestivalBoothInsert(vo);
					JOptionPane.showMessageDialog(null, "부스 등록을 완료했습니다.");
					selectBoothList();
					clearScreen();
				} catch (Exception e4) {
					// TODO: handle exception
					e4.printStackTrace();

				}

			}
		});

		btnFestBoothRegist.setBounds(134, 568, 109, 41);
		add(btnFestBoothRegist);

		JButton btnFestBoothDelete = new JButton("삭제");
		btnFestBoothDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = FBotable.getSelectedRow();
				int col = 0;
				int boothNo = (int) FBotable.getValueAt(row, col);
				System.out.println(boothNo);
				try {
					dao2.deleteFestivalBooth(boothNo);
					JOptionPane.showMessageDialog(null, "부스 삭제 완료했습니다.");
					selectBoothList();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		btnFestBoothDelete.setFont(new Font("\uD55C\uCEF4 \uACE0\uB515", btnFestBoothRegist.getFont().getStyle(), 20));
		btnFestBoothDelete.setBounds(357, 568, 109, 41);
		add(btnFestBoothDelete);

		// 새로 추가된 부스 검색 기능 (new)
		///////////////////////////////////////////////////////////////
		String searchText[] = {"부스명", "부스위치", "최대인원", "시작시간", "종료시간", "부스내용" };
		Boocombox = new JComboBox(searchText);
		Boocombox.setFont(new Font("\uD55C\uCEF4 \uACE0\uB515", Boocombox.getFont().getStyle(), 13));
		Boocombox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});

		Boosearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int sel = Boocombox.getSelectedIndex();
				System.out.println(sel);
				String text = Boosearch.getText();
				try {
					ArrayList list = dao2.boothsearch(sel, text);
					listTableModel.data = list;
					FBotable.setModel(listTableModel);
					listTableModel.fireTableDataChanged();
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
					JOptionPane.showMessageDialog(null, "부스검색 실패" + e2.getMessage());
				}

			}
		});

		Boocombox.setBounds(522, 35, 141, 23);
		add(Boocombox);

		JButton btnNewButton = new JButton("목록보기");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectBoothList();
			}
		});

		btnNewButton.setBounds(848, 35, 91, 23);
		add(btnNewButton);
		
		comMgrRank = new JComboBox();
		comMgrRank.setFont(new Font("\uD55C\uCEF4 \uACE0\uB515", comMgrRank.getFont().getStyle(), 14));

		comMgrRank.setModel(new DefaultComboBoxModel(new String[] { "부스 스태프", "부스 부매니저", "부스 매니저" }));
		comMgrRank.setBounds(335, 35, 130, 30);
		add(comMgrRank);
		
		JLabel lblNewLabel_2 = new JLabel("직책");
		lblNewLabel_2.setForeground(new Color(250, 255, 248));
		lblNewLabel_2.setFont(new Font("\uD55C\uCEF4 \uACE0\uB515", lblNewLabel.getFont().getStyle(), 20));
		lblNewLabel_2.setBounds(285, 34, 62, 30);
		add(lblNewLabel_2);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setForeground(new Color(129, 129, 129));
		separator.setBackground(new Color(179, 179, 179));
		separator.setBounds(493, 34, 2, 574);
		add(separator);
		// 부스 검색 기능 끝

		listTableModel = new ListTableModel();
		selectBoothList();

		FBotable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = FBotable.getSelectedRow();
				int col = 0;
				int boothNo = (int) FBotable.getValueAt(row, col);
				try {
					FestivalBoothVO vo = dao2.festivalBoothDetail(boothNo);
					comFBType.setSelectedItem(vo.getBoothtype());
					tfFBName.setText(vo.getBoothname());
					tfFBMax.setText(Integer.toString(vo.getBoothmax()));
					tfFBLoc.setText(vo.getBoothlocation());
					tfFBStart.setText(vo.getBoothstart());
					tfFBEnd.setText(vo.getBoothend());
					taFBContent.setText(vo.getBoothcontent());
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
		comFBType.setSelectedItem("식음료판매");
		tfFBName.setText("");
		tfFBLoc.setText("");
		tfFBStart.setText("");
		tfFBEnd.setText("");
		taFBContent.setText("");
		tfFBMax.setText("");
		comMgrRank.setSelectedItem("부스 매니저");
		
	}

	void selectBoothList() {
		System.out.println("selectBoothList");
		try {
			ArrayList list = dao2.boothlist();
			listTableModel.data = list;
			FBotable.setModel(listTableModel);
			listTableModel.fireTableDataChanged();

		} catch (Exception e8) {
			e8.printStackTrace();

		}
	}

	class ListTableModel extends AbstractTableModel {
		ArrayList data = new ArrayList();
		String[] colNames = { "부스번호", "관리자명", "관리자 직책", "부스유형", "부스명","최대인원" };

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
			ArrayList temp = (ArrayList) data.get(rowIndex);
			return temp.get(columnIndex);
		}

		public String getColumnName(int col) {
			return colNames[col];
		}
	}
}
