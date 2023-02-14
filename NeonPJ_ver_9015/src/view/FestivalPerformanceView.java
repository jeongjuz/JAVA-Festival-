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
import javax.swing.border.LineBorder;
import javax.swing.table.AbstractTableModel;

import model.FestivalPerformanceDAO;
import model.rec.FestivalPerformanceVO;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;

public class FestivalPerformanceView extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField tfName;
	private JTextField tfPlace;
	private JTextField tfStart;
	private JTextField tfEnd;
	private JTextField tfCast;
	private JTable tbperformancelist;
	private JTextField FPsearch;
	FestivalPerformanceDAO dao;
	private ListTableModel listTableModel;
	private int performanceNo;
	private JTextField tfNo;
	private JTextArea tfContent;
	private JComboBox Percombox;
	private int festivalno;
	/**
	 * Create the panel.
	 */
	public FestivalPerformanceView(int festivalno) {
		this.festivalno = festivalno;
		try {
			dao = new FestivalPerformanceDAO();
		} catch (Exception e) {
			// TODO: handle exception

		}

		setLayout(null);
		setBounds(12, 62, 984, 657);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(522, 121, 417, 488);
		add(scrollPane_1);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane_1.setViewportView(scrollPane);

		tbperformancelist = new JTable();
		scrollPane.setViewportView(tbperformancelist);

		tbperformancelist.setBorder(new LineBorder(new Color(0, 0, 0)));

		tbperformancelist.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {// 클릭이발생하면
				int row = tbperformancelist.getSelectedRow();
				int col = 0;// 컬럼은 중요하지 않기때문에 컬럼은 초기화
				int performanceNo = Integer.parseInt((String) tbperformancelist.getValueAt(row, col));

				FestivalPerformanceVO vo = new FestivalPerformanceVO();
				try {
					vo = dao.publicmodel(performanceNo);
				} catch (Exception e1) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(null, "부스결과실패:" + e1.getMessage());
					e1.printStackTrace();
				}
				// 검색된 비디오를 화면에 출력
				// tfNo.setText(String.valueOf(vo.getPerformanceno()));

				tfNo.setText(Integer.toString(vo.getPerformanceno()));
				tfName.setText(vo.getPerformancename());
				tfPlace.setText(vo.getPerformancelocation());
				tfStart.setText(vo.getPerformancestart());
				tfEnd.setText(vo.getPerformanceend());
				tfCast.setText(vo.getPerformancecast());
				tfContent.setText(vo.getPerformancecontent());

			}
		});
		JLabel lblNewLabel_2 = new JLabel("공연번호");
		lblNewLabel_2.setForeground(new Color(249, 255, 249));
		lblNewLabel_2.setFont(new Font("\uD55C\uCEF4 \uACE0\uB515", lblNewLabel_2.getFont().getStyle(), 20));
		lblNewLabel_2.setBounds(46, 34, 81, 24);
		add(lblNewLabel_2);

		JLabel lblNewLabel = new JLabel("공연명");
		lblNewLabel.setForeground(new Color(249, 255, 249));
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setFont(new Font("\uD55C\uCEF4 \uACE0\uB515", lblNewLabel.getFont().getStyle(), 20));
		lblNewLabel.setBounds(46, 84, 81, 24);
		add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("공연장소");
		lblNewLabel_1.setForeground(new Color(249, 255, 249));
		lblNewLabel_1.setFont(new Font("\uD55C\uCEF4 \uACE0\uB515", lblNewLabel.getFont().getStyle(), 20));
		lblNewLabel_1.setBounds(46, 134, 81, 24);
		add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("시작시간");
		lblNewLabel_1_1.setForeground(new Color(249, 255, 249));
		lblNewLabel_1_1.setFont(new Font("\uD55C\uCEF4 \uACE0\uB515", lblNewLabel_1_1.getFont().getStyle(), 20));
		lblNewLabel_1_1.setBounds(46, 184, 81, 24);
		add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_1_1 = new JLabel("종료시간");
		lblNewLabel_1_1_1.setForeground(new Color(249, 255, 249));
		lblNewLabel_1_1_1.setFont(new Font("\uD55C\uCEF4 \uACE0\uB515", lblNewLabel_1_1_1.getFont().getStyle(), 20));
		lblNewLabel_1_1_1.setBounds(46, 234, 81, 24);
		add(lblNewLabel_1_1_1);

		JLabel lblNewLabel_1_1_2 = new JLabel("출연진");
		lblNewLabel_1_1_2.setForeground(new Color(249, 255, 249));
		lblNewLabel_1_1_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_1_2.setFont(new Font("\uD55C\uCEF4 \uACE0\uB515", lblNewLabel_1_1_2.getFont().getStyle(), 20));
		lblNewLabel_1_1_2.setBounds(46, 284, 81, 24);
		add(lblNewLabel_1_1_2);

		JLabel lblNewLabel_1_1_2_1_1 = new JLabel("공연내용");
		lblNewLabel_1_1_2_1_1.setForeground(new Color(249, 255, 249));
		lblNewLabel_1_1_2_1_1.setFont(new Font("\uD55C\uCEF4 \uACE0\uB515", lblNewLabel_1_1_2_1_1.getFont().getStyle(), 20));
		lblNewLabel_1_1_2_1_1.setBounds(46, 334, 81, 24);
		add(lblNewLabel_1_1_2_1_1);

		tfNo = new JTextField();
		tfNo.setFont(new Font("\uD55C\uCEF4 \uACE0\uB515", tfNo.getFont().getStyle(), 14));
		tfNo.setColumns(10);
		tfNo.setBounds(134, 35, 331, 24);
		add(tfNo);

		tfName = new JTextField();
		tfName.setFont(new Font("\uD55C\uCEF4 \uACE0\uB515", tfName.getFont().getStyle(), 14));
		tfName.setBounds(134, 85, 331, 24);
		add(tfName);
		tfName.setColumns(10);

		tfPlace = new JTextField();
		tfPlace.setFont(new Font("\uD55C\uCEF4 \uACE0\uB515", tfPlace.getFont().getStyle(), 14));
		tfPlace.setColumns(10);
		tfPlace.setBounds(134, 135, 331, 24);
		add(tfPlace);

		tfStart = new JTextField();
		tfStart.setFont(new Font("\uD55C\uCEF4 \uACE0\uB515", tfStart.getFont().getStyle(), 14));
		tfStart.setColumns(10);
		tfStart.setBounds(134, 185, 331, 24);
		add(tfStart);

		tfEnd = new JTextField();
		tfEnd.setFont(new Font("\uD55C\uCEF4 \uACE0\uB515", tfEnd.getFont().getStyle(), 14));
		tfEnd.setColumns(10);
		tfEnd.setBounds(134, 235, 331, 24);
		add(tfEnd);

		tfCast = new JTextField();
		tfCast.setFont(new Font("\uD55C\uCEF4 \uACE0\uB515", tfCast.getFont().getStyle(), 14));
		tfCast.setColumns(10);
		tfCast.setBounds(134, 285, 331, 24);
		add(tfCast);

		tfContent = new JTextArea();
		tfContent.setFont(new Font("\uD55C\uCEF4 \uACE0\uB515", tfContent.getFont().getStyle(), 14));
		tfContent.setBounds(134, 335, 331, 214);
		add(tfContent);

		FPsearch = new JTextField();
		FPsearch.setFont(new Font("\uD55C\uCEF4 \uACE0\uB515", FPsearch.getFont().getStyle(), 16));
		FPsearch.setToolTipText("");
		FPsearch.setBounds(522, 70, 417, 40);
		add(FPsearch);
		FPsearch.setColumns(10);

		JButton btnInsertPerform = new JButton("등록");
		btnInsertPerform.setFont(new Font("\uD55C\uCEF4 \uACE0\uB515", btnInsertPerform.getFont().getStyle(), 20));
		btnInsertPerform.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String performancecontent = tfContent.getText();
				String performancestart = tfStart.getText();
				String performanceend = tfEnd.getText();
				String performancelocation = tfPlace.getText();
				String performancename = tfName.getText();
				String performancecast = tfCast.getText();

				FestivalPerformanceVO vo = new FestivalPerformanceVO(performanceNo, performancename,
						performancelocation, performancestart, performanceend, performancecast, performancecontent);
				try {

					dao.FestivalPerformanceInsert(vo,festivalno);
					JOptionPane.showMessageDialog(null, "공연 등록을 완료했습니다.");
					selectperformanceList();
					// 화면요소 비우기
					clearScreen();
				} catch (Exception e5) {
					e5.printStackTrace();
					// TODO: handle exception
				}
			}
		});
		btnInsertPerform.setBounds(134, 568, 109, 41);
		add(btnInsertPerform);

		listTableModel = new ListTableModel();
		selectperformanceList();

		JButton Deletebtn = new JButton("삭제");
		Deletebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int num = Integer.parseInt(tfNo.getText());
					dao.performanceDelete(num);

					clearScreen();
					selectperformanceList();

				} catch (Exception e8) {
					e8.printStackTrace();

				}

			}
		});
		Deletebtn.setFont(new Font("\uD55C\uCEF4 \uACE0\uB515", btnInsertPerform.getFont().getStyle(), 20));
		Deletebtn.setBounds(357, 568, 109, 41);
		add(Deletebtn);

		// 공공시설 검색 기능 시작 (new)
		///////////////////////////////////////////////////////////////
		String searchText[] = { "공연명", "공연장소", "시작시간", "종료시간", "출연진", "공연내용" };
		Percombox = new JComboBox(searchText);
		Percombox.setFont(new Font("\uD55C\uCEF4 \uACE0\uB515", Percombox.getFont().getStyle(), 13));
		Percombox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		Percombox.setBounds(522, 35, 143, 23);
		add(Percombox);

		JButton btnNewButton_1 = new JButton("목록보기");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectperformanceList();
			}
		});
		btnNewButton_1.setBounds(848, 35, 91, 23);
		add(btnNewButton_1);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setForeground(new Color(129, 129, 129));
		separator.setBackground(new Color(179, 179, 179));
		separator.setBounds(493, 34, 2, 574);
		add(separator);

		FPsearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int sel = Percombox.getSelectedIndex();
				System.out.println(sel);
				String text = FPsearch.getText();
				try {
					ArrayList list = dao.publicsearch(sel, text);
					listTableModel.data = list;
					tbperformancelist.setModel(listTableModel);
					listTableModel.fireTableDataChanged();
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
					JOptionPane.showMessageDialog(null, "공연 검색 실패" + e2.getMessage());
				}

			}
		});
		
		JLabel background = new JLabel("");
		background.setIcon(new ImageIcon(MemberBoothView.class.getResource("/img/background_2.jpeg")));
		background.setBounds(0, 0, 984, 657);
		add(background);
	}
	// 공공시설 검색 기능 끝

	public void clearScreen() {
		tfName.setText(null);
		tfPlace.setText(null);
		tfStart.setText(null);
		tfEnd.setText(null);
		tfCast.setText(null);
		tfNo.setText(null);
		tfContent.setText(null);

	}

	void selectperformanceList() {
		System.out.println("selectperformanceList");
		try {
			ArrayList list = dao.publicList(festivalno);
			listTableModel.data = list;
			tbperformancelist.setModel(listTableModel);
			listTableModel.fireTableDataChanged();

		} catch (Exception e8) {
			e8.printStackTrace();

		}
	}

	class ListTableModel extends AbstractTableModel {
		ArrayList data = new ArrayList();
		String[] colNames = { "공연번호", "공연명", "공연장소", "시작시간", "종료시간", "출연진", "공연내용" };

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
