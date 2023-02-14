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

import model.MemberPerformanceDAO;
import model.rec.MemberPerformanceVO;

public class MemberPerformanceView extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField tfname;
	private JTextField tfpfplace;
	private JTable tbPerformancelist;
	private MemberPerformanceDAO dao;
	private ListTableModel listTableModel;
	private JTextField Mpsearch;
	private JTextField tfpfstart;
	private JTextField tfpfend;
	private JTextField tfpfname;
	private int festNo;
	private int performanceNo;
	private JComboBox MPcombox;

	/**
	 * Create the panel.
	 */
	public MemberPerformanceView(int festNo) {
		this.festNo = festNo;
		try {
			dao = new MemberPerformanceDAO();

		} catch (Exception e) {
			// TODO: handle exception
		}
		setLayout(null);
		setBounds(12, 62, 984, 657);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(510, 96, 430, 512);
		add(scrollPane);

		tbPerformancelist = new JTable();
		tbPerformancelist.setFont(new Font("한컴 고딕", Font.PLAIN, 12));
		scrollPane.setViewportView(tbPerformancelist);
		tbPerformancelist.setModel(new DefaultTableModel(
				new Object[][] { { null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null }, { null, null, null, null, "", null, null },
						{ null, null, null, null, null, null, null }, { null, null, null, null, null, null, null }, },
				new String[] { "\uACF5\uC5F0\uBC88\uD638", "\uACF5\uC5F0\uBA85", "\uACF5\uC5F0\uC7A5\uC18C",
						"\uC2DC\uC791\uC2DC\uAC04", "\uC885\uB8CC\uC2DC\uAC04", "\uCD9C\uC5F0\uC9C4",
						"\uACF5\uC5F0\uB0B4\uC6A9" }));
		tbPerformancelist.setBorder(new LineBorder(new Color(0, 0, 0)));

		JLabel lblNewLabel = new JLabel("공연명");
		lblNewLabel.setForeground(new Color(249, 255, 249));
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setFont(new Font("한컴 고딕", Font.PLAIN, 20));
		lblNewLabel.setBounds(46, 46, 88, 33);
		add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("공연장소");
		lblNewLabel_1.setForeground(new Color(249, 255, 249));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setFont(new Font("한컴 고딕", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(46, 92, 88, 33);
		add(lblNewLabel_1);

		JLabel lblNewLabel_1_1_2_1_1 = new JLabel("공연내용");
		lblNewLabel_1_1_2_1_1.setForeground(new Color(249, 255, 249));
		lblNewLabel_1_1_2_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_1_2_1_1.setFont(new Font("한컴 고딕", Font.PLAIN, 20));
		lblNewLabel_1_1_2_1_1.setBounds(46, 228, 88, 380);
		add(lblNewLabel_1_1_2_1_1);

		tfname = new JTextField();
		tfname.setFont(new Font("한컴 고딕", Font.PLAIN, 20));
		tfname.setBounds(134, 46, 330, 33);
		add(tfname);
		tfname.setColumns(10);

		tfpfplace = new JTextField();
		tfpfplace.setFont(new Font("한컴 고딕", Font.PLAIN, 20));
		tfpfplace.setColumns(10);
		tfpfplace.setBounds(134, 92, 330, 33);
		add(tfpfplace);

		JTextArea tfpfcontent = new JTextArea();
		tfpfcontent.setFont(new Font("한컴 고딕", Font.PLAIN, 20));
		tfpfcontent.setBounds(134, 228, 330, 380);
		add(tfpfcontent);

		Mpsearch = new JTextField();
		Mpsearch.setFont(new Font("한컴 고딕", Font.PLAIN, 20));
		Mpsearch.setToolTipText("");
		Mpsearch.setBounds(610, 46, 225, 33);
		add(Mpsearch);
		Mpsearch.setColumns(10);

		JLabel lblNewLabel_1_1 = new JLabel("시작시간");
		lblNewLabel_1_1.setForeground(new Color(249, 255, 249));
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_1.setFont(new Font("한컴 고딕", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(46, 137, 88, 33);
		add(lblNewLabel_1_1);

		tfpfstart = new JTextField();
		tfpfstart.setFont(new Font("한컴 고딕", Font.PLAIN, 20));
		tfpfstart.setColumns(10);
		tfpfstart.setBounds(134, 137, 113, 33);
		add(tfpfstart);

		JLabel lblNewLabel_1_1_1 = new JLabel("종료시간");
		lblNewLabel_1_1_1.setForeground(new Color(249, 255, 249));
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_1_1.setFont(new Font("한컴 고딕", Font.PLAIN, 20));
		lblNewLabel_1_1_1.setBounds(263, 137, 88, 33);
		add(lblNewLabel_1_1_1);

		tfpfend = new JTextField();
		tfpfend.setFont(new Font("한컴 고딕", Font.PLAIN, 20));
		tfpfend.setColumns(10);
		tfpfend.setBounds(351, 137, 113, 33);
		add(tfpfend);

		JLabel lblNewLabel_1_2 = new JLabel("출연진");
		lblNewLabel_1_2.setForeground(new Color(249, 255, 249));
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_2.setFont(new Font("한컴 고딕", Font.PLAIN, 20));
		lblNewLabel_1_2.setBounds(46, 182, 88, 33);
		add(lblNewLabel_1_2);

		tfpfname = new JTextField();
		tfpfname.setFont(new Font("한컴 고딕", Font.PLAIN, 20));
		tfpfname.setColumns(10);
		tfpfname.setBounds(134, 182, 330, 33);
		add(tfpfname);

		/////////////////////////
		// 공연 검색 기능 시작 (new)
		JButton btnNewButton = new JButton("목록보기");
		btnNewButton.setFont(new Font("한컴 고딕", Font.PLAIN, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectperformanceList();
			}
		});
		btnNewButton.setBounds(849, 46, 91, 33);
		add(btnNewButton);

		String searchText[] = { "공연명", "공연장소", "시작시간", "종료시간", "출연진", "공연내용" };
		MPcombox = new JComboBox(searchText);
		MPcombox.setFont(new Font("Dialog", Font.PLAIN, 12));
		MPcombox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		MPcombox.setBounds(510, 46, 88, 33);
		add(MPcombox);

		Mpsearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int sel = MPcombox.getSelectedIndex();
				System.out.println(sel);
				String text = Mpsearch.getText();
				try {
					ArrayList list = dao.mpsearch(festNo, sel, text);
					listTableModel.data = list;
					tbPerformancelist.setModel(listTableModel);
					listTableModel.fireTableDataChanged();
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
					JOptionPane.showMessageDialog(null, "공연 검색 실패" + e2.getMessage());
				}

			}
		});
		// 공연 검색 기능 끝
		//////////////////////////

		listTableModel = new ListTableModel();
		selectperformanceList();

		tbPerformancelist.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {// 클릭이발생하면
				int row = tbPerformancelist.getSelectedRow();
				int col = 0;// 컬럼은 중요하지 않기때문에 컬럼은 초기화
				int performanceNo = (int) tbPerformancelist.getValueAt(row, col);
				System.out.println(performanceNo);

				MemberPerformanceVO vo = new MemberPerformanceVO();
				try {
					vo = dao.performancemodel(performanceNo);
				} catch (Exception e1) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(null, "부스결과실패:" + e1.getMessage());
					e1.printStackTrace();
				}
				// 검색된 비디오를 화면에 출력
				tfname.setText((vo.getName()));
				tfpfplace.setText(vo.getPlace());
				;
				tfpfstart.setText(vo.getStarttime());
				tfpfend.setText(vo.getEndtime());
				tfpfname.setText(vo.getCastname());
				tfpfcontent.setText(vo.getContent());

			}
		});
		
		JLabel background = new JLabel("");
		background.setIcon(new ImageIcon(MemberBoothView.class.getResource("/img/background_2.jpeg")));
		background.setBounds(0, 0, 984, 657);
		add(background);
	}

	void selectperformanceList() {
		System.out.println("selectperformanceList");
		try {
			ArrayList list = dao.performancelist(this.festNo);
			listTableModel.data = list;
			tbPerformancelist.setModel(listTableModel);
			listTableModel.fireTableDataChanged();

		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	// 테이블 모델 클래스
	class ListTableModel extends AbstractTableModel {
		ArrayList data = new ArrayList();
		String[] colNames = { "공연번호", "공연명", "공연위치", "시작시간", "종료시간", "출연진", "공연내용" };

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
