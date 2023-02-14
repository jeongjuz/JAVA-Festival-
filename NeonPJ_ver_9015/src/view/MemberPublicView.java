package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

import model.MemberPublicDAO;
import model.rec.MemberBoothVO;
import model.rec.MemberPublicVO;

import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

public class MemberPublicView extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField tftypename;
	private JTextField tfname;
	private JTable tbPubliclist;
	private MemberPublicDAO dao;
	private JTextField textField_8;
	private JTextField tflocation;
	private ListTableModel listTableModel;
	private int festNo;
	private int publicfacilityNo;

	/**
	 * Create the panel.
	 */
	public MemberPublicView(int festNo) {
		this.festNo = festNo;
		try {
			dao = new MemberPublicDAO();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		setLayout(null);
		setBounds(12, 62, 984, 657);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(510, 96, 430, 512);
		add(scrollPane);

		tbPubliclist = new JTable();
		tbPubliclist.setFont(new Font("한컴 고딕", Font.PLAIN, 12));
		scrollPane.setViewportView(tbPubliclist);
		tbPubliclist.setModel(new DefaultTableModel(
				new Object[][] { { null, null, null, null }, { null, null, null, null }, { null, null, null, null },
						{ null, null, null, null }, { null, null, null, null }, },
				new String[] { "\uC2DC\uC124\uBC88\uD638", "\uC2DC\uC124\uD0C0\uC785\uBA85", "\uC2DC\uC124\uBA85",
						"\uC704\uCE58" }));
		tbPubliclist.setBorder(new LineBorder(new Color(0, 0, 0)));

		JLabel lblNewLabel = new JLabel("시설타입");
		lblNewLabel.setForeground(new Color(249, 255, 249));
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setFont(new Font("한컴 고딕", Font.PLAIN, 20));
		lblNewLabel.setBounds(46, 49, 88, 33);
		add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("시설명");
		lblNewLabel_1.setForeground(new Color(249, 255, 249));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setFont(new Font("한컴 고딕", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(46, 92, 88, 33);
		add(lblNewLabel_1);

		JLabel lblNewLabel_1_1_2_1_1 = new JLabel("사진");
		lblNewLabel_1_1_2_1_1.setForeground(new Color(249, 255, 249));
		lblNewLabel_1_1_2_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_1_2_1_1.setFont(new Font("한컴 고딕", Font.PLAIN, 20));
		lblNewLabel_1_1_2_1_1.setBounds(46, 184, 88, 424);
		add(lblNewLabel_1_1_2_1_1);

		tftypename = new JTextField();
		tftypename.setFont(new Font("한컴 고딕", Font.PLAIN, 20));
		tftypename.setBounds(134, 49, 330, 33);
		add(tftypename);
		tftypename.setColumns(10);

		tfname = new JTextField();
		tfname.setFont(new Font("한컴 고딕", Font.PLAIN, 20));
		tfname.setColumns(10);
		tfname.setBounds(134, 92, 330, 33);
		add(tfname);

		textField_8 = new JTextField();
		textField_8.setFont(new Font("한컴 고딕", Font.PLAIN, 20));
		textField_8.setToolTipText("");
		textField_8.setBounds(510, 49, 430, 33);
		add(textField_8);
		textField_8.setColumns(10);

		JLabel lblNewLabel_1_2 = new JLabel("위치");
		lblNewLabel_1_2.setForeground(new Color(249, 255, 249));
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_2.setFont(new Font("한컴 고딕", Font.PLAIN, 20));
		lblNewLabel_1_2.setBounds(46, 141, 88, 33);
		add(lblNewLabel_1_2);

		tflocation = new JTextField();
		tflocation.setFont(new Font("한컴 고딕", Font.PLAIN, 20));
		tflocation.setColumns(10);
		tflocation.setBounds(134, 141, 330, 33);
		add(tflocation);

		// 사진 출력 객체 시작(update) 
		JLabel lblPicture = new JLabel("");
		lblPicture.setBounds(134, 187, 330, 420);
		add(lblPicture);
		// 사진 출력 객체 끝 

		listTableModel = new ListTableModel();
		selectPubliclist();

		// 공공시설 리스트 클릭 이벤트 시작 (update) 
		tbPubliclist.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {// 클릭이발생하면
				int row = tbPubliclist.getSelectedRow();
				int col = 0;// 컬럼은 중요하지 않기때문에 컬럼은 초기화
				int publicfacilityNo = Integer.parseInt((String) tbPubliclist.getValueAt(row, col));

				MemberPublicVO vo = new MemberPublicVO();
				try {
					vo = dao.publicmodel(publicfacilityNo);
				} catch (Exception e1) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(null, "부스결과실패:" + e1.getMessage());
				}
				// 검색된 비디오를 화면에 출력
				tftypename.setText(vo.getTypename());
				tfname.setText(vo.getName());
				tflocation.setText(vo.getLocation());

				String workingDir = System.getProperty("user.dir"); // 현재 작업폴더(프로젝트폴더)를 기준디렉토리로 설정
				// 이미지&경로를 화면에 출력
				System.out.println(vo.getPublicPicturePath());
				ImageIcon img = new ImageIcon(workingDir + vo.getPublicPicturePath()); // 출력용 - 절대경로 사용
				lblPicture.setIcon(img);

			}
		});
		// 공공시설 리스트 클릭 이벤트 끝 
		
		JLabel background = new JLabel("");
		background.setIcon(new ImageIcon(MemberBoothView.class.getResource("/img/background_2.jpeg")));
		background.setBounds(0, 0, 984, 657);
		add(background);
	}

	void selectPubliclist() {
		System.out.println("selectPubliclist");
		try {
			ArrayList list = dao.Publiclist(this.festNo);

			listTableModel.data = list;
			tbPubliclist.setModel(listTableModel);
			listTableModel.fireTableDataChanged();

		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	// 테이블 모델 클래스
	class ListTableModel extends AbstractTableModel {
		ArrayList data = new ArrayList();
		String[] colNames = { "시설번호", "시설타입명", "시설명", "위치" };

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
