package view;

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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;

import model.MemberPostDAO;
import model.MemberPostReplyDAO;
import model.rec.MemberPostReplyVO;
import model.rec.MemberPostVO;

import javax.swing.JTextPane;
import javax.swing.JEditorPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import java.awt.Color;

public class MemberPostManagement extends JPanel {

	/**
	 * Create the panel.
	 */

	private String memberId;
	private int festivalNo;
	private JTextField textField;
	private JTable tbPostList;
	private MemberPostDAO postDAO;
	private MemberPostReplyDAO postReplyDAO;
	private ListTableModel listTableModel;
	private ListTableReplyModel listTableReplyModel;

	// 패널 선언
	private JPanel postListView; // 게시글 리스트
	private JPanel postWriteView; // 게시글 쓰기
	private JPanel postView; // 게시글 조회
	private JTextField tfPostNo;
	private JTextField tfWriterNo;
	private JTextField tfPostTitle;
	private JTextField tfWriteMemberId;
	private JTextArea taPostContent;
	private JTable tblReplyList;
	private JLabel lblTitle;
	private JLabel lblWriterName;
	private JLabel lblPostDate;
	private JLabel lblContent;
	private JButton btnModify;
	private JButton btnDelete;
	private JLabel lblPostNo;

	public MemberPostManagement(String memberId, int festivalNo) {

		try {
			postDAO = new MemberPostDAO(festivalNo);
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			postReplyDAO = new MemberPostReplyDAO();
		} catch (Exception e) {
			e.printStackTrace();
		}

		this.memberId = memberId;
		this.festivalNo = festivalNo;
		System.out.println(this.memberId);
		System.out.println(festivalNo);
		setBounds(12, 62, 984, 657);
		setLayout(null);
								
										// 게시글리스트
										postListView = new JPanel();
										postListView.setBounds(0, 0, 984, 657);
										add(postListView);
										postListView.setLayout(null);
										
												JLabel lblNewLabel = new JLabel("게시글 목록");
												lblNewLabel.setForeground(new Color(249, 255, 249));
												lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
												lblNewLabel.setFont(new Font("한컴 고딕", Font.PLAIN, 20));
												lblNewLabel.setBounds(403, 49, 178, 33);
												postListView.add(lblNewLabel);
												
														JLabel lblNewLabel_3 = new JLabel("게시글검색");
														lblNewLabel_3.setForeground(new Color(249, 255, 249));
														lblNewLabel_3.setFont(new Font("한컴 고딕", Font.PLAIN, 16));
														lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
														lblNewLabel_3.setBounds(43, 104, 94, 33);
														postListView.add(lblNewLabel_3);
														
																textField = new JTextField();
																textField.setBounds(147, 104, 768, 33);
																postListView.add(textField);
																textField.setColumns(10);
																
																		JScrollPane scrollPane = new JScrollPane();
																		scrollPane.setBounds(46, 161, 885, 396);
																		postListView.add(scrollPane);
																		
																				tbPostList = new JTable(listTableModel);
																				scrollPane.setViewportView(tbPostList);
																				tbPostList.setFont(new Font("한컴 고딕", Font.PLAIN, 12));
																				
																						JButton btnShowWriteView = new JButton("게시글 작성");
																						btnShowWriteView.setFont(new Font("한컴 고딕", Font.PLAIN, 18));
																						btnShowWriteView.setBounds(423, 567, 138, 33);
																						postListView.add(btnShowWriteView);
																						
																								// 게시글 선택해 조회하기
																								tbPostList.addMouseListener(new MouseAdapter() {
																									@Override
																									public void mouseClicked(MouseEvent e) {
																										int row = tbPostList.getSelectedRow();
																										int col = 0;
																										System.out.println(tbPostList.getValueAt(row, col));
																										int postNo = (int) tbPostList.getValueAt(row, col);
																										MemberPostVO vo = new MemberPostVO();
																						
																										try {
																											vo = postDAO.selectPostByPostNo(postNo);
																											System.out.println(vo.getMemberName());
																											tfPostNo.setText(Integer.toString(vo.getPostNo()));
																											lblTitle.setText(vo.getPostTitle());
																											lblContent.setText(vo.getPostContent());
																											lblWriterName.setText(vo.getMemberName());
																											tfWriterNo.setText(Integer.toString(vo.getMemberNo()));
																											lblPostDate.setText(vo.getPostDate());
																											System.out.println(vo.getMemberId());
																											System.out.println(memberId);
																						
																											if (!memberId.equals(vo.getMemberId())) {
																												btnModify.setVisible(false);
																												btnDelete.setVisible(false);
																						
																											} else {
																												btnModify.setVisible(true);
																												btnDelete.setVisible(true);
																											}
																						
																											listTableReplyModel = new ListTableReplyModel();
																											selectPostReplyList();
																						
																											postListView.setVisible(false);
																											postView.setVisible(true);
																						
																										} catch (Exception e2) {
																											// TODO: handle exception
																											e2.printStackTrace();
																										}
																									}
																								});
																								
																										// 게시글 작성 화면으로 이동
																										btnShowWriteView.addActionListener(new ActionListener() {
																											public void actionPerformed(ActionEvent e) {
																												// 입력란 초기화
																												lblPostNo.setText("");
																												tfPostTitle.setText("");
																												taPostContent.setText("");
																												// 화면 전환
																												postListView.setVisible(false);
																												postView.setVisible(false);
																												postWriteView.setVisible(true);
																											}
																										});
																										
																										JLabel background = new JLabel("");
																										background.setIcon(new ImageIcon(MemberBoothView.class.getResource("/img/background_2.jpeg")));
																										background.setBounds(0, 0, 984, 657);
																										postListView.add(background);
						
								// 게시글 조회
								postView = new JPanel();
								postView.setBounds(0, 0, 984, 657);
								add(postView);
								postView.setVisible(false);
								postView.setLayout(null);
								
										tblReplyList = new JTable();
										tblReplyList.setFont(new Font("한컴 고딕", Font.PLAIN, 12));
										tblReplyList.setBounds(510, 175, 415, 380);
										postView.add(tblReplyList);
										
												btnModify = new JButton("수정");
												btnModify.setFont(new Font("한컴 고딕", Font.PLAIN, 15));
												
														btnModify.setBounds(722, 105, 99, 33);
														postView.add(btnModify);
														
																btnDelete = new JButton("삭제");
																btnDelete.setFont(new Font("한컴 고딕", Font.PLAIN, 15));
																
																		btnDelete.setBounds(826, 105, 99, 33);
																		postView.add(btnDelete);
																		
																				JTextArea taReplyContent = new JTextArea();
																				taReplyContent.setFont(new Font("한컴 고딕", Font.PLAIN, 20));
																				taReplyContent.setBounds(510, 565, 298, 33);
																				postView.add(taReplyContent);
																				
																						JButton btnWriteReply = new JButton("댓글 쓰기");
																						btnWriteReply.setFont(new Font("한컴 고딕", Font.PLAIN, 15));
																						
																								btnWriteReply.setBounds(820, 565, 105, 33);
																								postView.add(btnWriteReply);
																								
																										tfPostNo = new JTextField();
																										tfPostNo.setBounds(543, 309, 116, 21);
																										postView.add(tfPostNo);
																										tfPostNo.setColumns(10);
																										
																												tfWriterNo = new JTextField();
																												tfWriterNo.setBounds(543, 209, 116, 21);
																												postView.add(tfWriterNo);
																												tfWriterNo.setColumns(10);
																												
																														JButton btnNewButton = new JButton("뒤로가기");
																														btnNewButton.setFont(new Font("한컴 고딕", Font.PLAIN, 15));
																														
																																// 게시글 목록으로 이동
																																btnNewButton.addActionListener(new ActionListener() {
																																	public void actionPerformed(ActionEvent e) {
																																		postView.setVisible(false);
																																		postListView.setVisible(true);
																																	}
																																});
																																
																																		btnNewButton.setBounds(46, 49, 102, 33);
																																		postView.add(btnNewButton);
																																		
																																				tfWriteMemberId = new JTextField();
																																				tfWriteMemberId.setColumns(10);
																																				tfWriteMemberId.setBounds(543, 259, 116, 21);
																																				postView.add(tfWriteMemberId);
																																				
																																						JSeparator separator = new JSeparator();
																																						separator.setBounds(46, 151, 879, 14);
																																						postView.add(separator);
																																						
																																								lblTitle = new JLabel("제목");
																																								lblTitle.setForeground(new Color(249, 255, 249));
																																								lblTitle.setFont(new Font("한컴 고딕", Font.PLAIN, 20));
																																								lblTitle.setBounds(166, 49, 407, 33);
																																								postView.add(lblTitle);
																																								
																																										lblWriterName = new JLabel("작성자");
																																										lblWriterName.setForeground(new Color(249, 255, 249));
																																										lblWriterName.setFont(new Font("한컴 고딕", Font.PLAIN, 20));
																																										lblWriterName.setBounds(132, 105, 161, 33);
																																										postView.add(lblWriterName);
																																										
																																												lblPostDate = new JLabel("작성시간");
																																												lblPostDate.setForeground(new Color(249, 255, 249));
																																												lblPostDate.setFont(new Font("한컴 고딕", Font.PLAIN, 20));
																																												lblPostDate.setBounds(422, 105, 288, 33);
																																												postView.add(lblPostDate);
																																												
																																														JSeparator separator_1 = new JSeparator();
																																														separator_1.setBounds(46, 92, 879, 14);
																																														postView.add(separator_1);
																																														
																																																JSeparator separator_2 = new JSeparator();
																																																separator_2.setOrientation(SwingConstants.VERTICAL);
																																																separator_2.setBounds(291, 105, 41, 33);
																																																postView.add(separator_2);
																																																
																																																		JSeparator separator_2_1 = new JSeparator();
																																																		separator_2_1.setOrientation(SwingConstants.VERTICAL);
																																																		separator_2_1.setBounds(485, 175, 13, 423);
																																																		postView.add(separator_2_1);
																																																		
																																																				lblContent = new JLabel("글 내용");
																																																				lblContent.setForeground(new Color(249, 255, 249));
																																																				lblContent.setHorizontalAlignment(SwingConstants.LEFT);
																																																				lblContent.setFont(new Font("한컴 고딕", Font.PLAIN, 20));
																																																				lblContent.setBounds(46, 175, 415, 423);
																																																				postView.add(lblContent);
																																																				
																																																						JLabel lblNewLabel_1 = new JLabel("작성자 : ");
																																																						lblNewLabel_1.setForeground(new Color(249, 255, 249));
																																																						lblNewLabel_1.setFont(new Font("한컴 고딕", Font.PLAIN, 20));
																																																						lblNewLabel_1.setBounds(46, 105, 74, 33);
																																																						postView.add(lblNewLabel_1);
																																																						
																																																								JLabel lblNewLabel_1_1 = new JLabel("작성시간 : ");
																																																								lblNewLabel_1_1.setForeground(new Color(249, 255, 249));
																																																								lblNewLabel_1_1.setFont(new Font("한컴 고딕", Font.PLAIN, 20));
																																																								lblNewLabel_1_1.setBounds(314, 105, 96, 33);
																																																								postView.add(lblNewLabel_1_1);
																																																								
																																																										// 게시글 수정 화면으로 이동
																																																										btnModify.addActionListener(new ActionListener() {
																																																											public void actionPerformed(ActionEvent e) {
																																																												int postNo = Integer.parseInt(tfPostNo.getText());
																																																												MemberPostVO vo = new MemberPostVO();
																																																								
																																																												try {
																																																													vo = postDAO.selectPostByPostNo(postNo);
																																																													System.out.println(vo.getMemberName());
																																																													tfPostTitle.setText(vo.getPostTitle());
																																																													taPostContent.setText(vo.getPostContent());
																																																													lblPostNo.setText(Integer.toString(vo.getPostNo()));
																																																												} catch (Exception e2) {
																																																													// TODO: handle exception
																																																													e2.printStackTrace();
																																																												}
																																																												postListView.setVisible(false);
																																																												postView.setVisible(false);
																																																												postWriteView.setVisible(true);
																																																											}
																																																										});
																																																										
																																																												btnDelete.addActionListener(new ActionListener() {
																																																													public void actionPerformed(ActionEvent e) {
																																																														int postNo = Integer.parseInt(tfPostNo.getText());
																																																														try {
																																																															postDAO.deletePost(postNo);
																																																															JOptionPane.showMessageDialog(null, "삭제 완료되었습니다.");
																																																															postListView.setVisible(true);
																																																															postView.setVisible(false);
																																																															postWriteView.setVisible(false);
																																																															selectPostList();
																																																														} catch (SQLException e1) {
																																																															// TODO Auto-generated catch block
																																																															e1.printStackTrace();
																																																														}
																																																										
																																																													}
																																																												});
																																																												
																																																														// 댓글 쓰기
																																																														btnWriteReply.addActionListener(new ActionListener() {
																																																															public void actionPerformed(ActionEvent e) {
																																																																String replyContent = taReplyContent.getText();
																																																																int postNo = Integer.parseInt(tfPostNo.getText());
																																																																MemberPostReplyVO vo = new MemberPostReplyVO(postNo, memberId, replyContent);
																																																																try {
																																																																	postReplyDAO.registPostReply(vo);
																																																																	JOptionPane.showMessageDialog(null, "댓글 작성 완료되었습니다.");
																																																												
																																																																	postListView.setVisible(false);
																																																																	postView.setVisible(true);
																																																																	selectPostReplyList();
																																																																} catch (Exception e1) {
																																																																	// TODO Auto-generated catch block
																																																																	e1.printStackTrace();
																																																																}
																																																												
																																																															}
																																																														});
																																																														
																																																														JLabel background2 = new JLabel("");
																																																														background2.setIcon(new ImageIcon(MemberBoothView.class.getResource("/img/background_2.jpeg")));
																																																														background2.setBounds(0, 0, 984, 657);
																																																														postView.add(background2);
		
				// 게시글 작성
				postWriteView = new JPanel();
				postWriteView.setBounds(0, 0, 984, 657);
				add(postWriteView);
				postWriteView.setLayout(null);
				
						taPostContent = new JTextArea();
						taPostContent.setFont(new Font("한컴 고딕", Font.PLAIN, 20));
						taPostContent.setBounds(108, 143, 817, 395);
						postWriteView.add(taPostContent);
						
								JLabel lblPostTitle = new JLabel("제목");
								lblPostTitle.setForeground(new Color(249, 255, 249));
								lblPostTitle.setFont(new Font("한컴 고딕", Font.PLAIN, 20));
								lblPostTitle.setBounds(46, 100, 50, 33);
								postWriteView.add(lblPostTitle);
								
										tfPostTitle = new JTextField();
										tfPostTitle.setFont(new Font("한컴 고딕", Font.PLAIN, 20));
										tfPostTitle.setBounds(108, 100, 817, 33);
										postWriteView.add(tfPostTitle);
										tfPostTitle.setColumns(10);
										
												JLabel lblPostContent = new JLabel("내용");
												lblPostContent.setForeground(new Color(249, 255, 249));
												lblPostContent.setFont(new Font("한컴 고딕", Font.PLAIN, 20));
												lblPostContent.setBounds(46, 143, 50, 395);
												postWriteView.add(lblPostContent);
												
														JButton btnExit = new JButton("나가기");
														btnExit.setFont(new Font("한컴 고딕", Font.PLAIN, 18));
														btnExit.setBounds(352, 564, 100, 33);
														postWriteView.add(btnExit);
														
																btnExit.addActionListener(new ActionListener() {
																	public void actionPerformed(ActionEvent arg0) {
																		postListView.setVisible(true);
																		postView.setVisible(false);
																		postWriteView.setVisible(false);
																	}
																});
																
																		JButton btnWritePost = new JButton("글쓰기");
																		btnWritePost.setFont(new Font("한컴 고딕", Font.PLAIN, 18));
																		
																				btnWritePost.setBounds(524, 564, 100, 33);
																				postWriteView.add(btnWritePost);
																				
																						JLabel lblPostTitle_1 = new JLabel("글쓰기");
																						lblPostTitle_1.setForeground(new Color(249, 255, 249));
																						lblPostTitle_1.setHorizontalAlignment(SwingConstants.CENTER);
																						lblPostTitle_1.setFont(new Font("한컴 고딕", Font.PLAIN, 20));
																						lblPostTitle_1.setBounds(436, 49, 111, 33);
																						postWriteView.add(lblPostTitle_1);
																						
																								lblPostNo = new JLabel("New label");
																								lblPostNo.setBounds(131, 158, 57, 15);
																								postWriteView.add(lblPostNo);
																								
																										// 글쓰기
																										btnWritePost.addActionListener(new ActionListener() {
																											public void actionPerformed(ActionEvent e) {
																												String postTitle = tfPostTitle.getText();
																												String postContent = taPostContent.getText();
																								
																												String postNo = lblPostNo.getText();
																								
																												if (postNo.equals("")) {
																													// 글 번호가 없는 경우 insert
																													MemberPostVO vo = new MemberPostVO(memberId, postTitle, postContent);
																													try {
																														postDAO.registPost(vo);
																														JOptionPane.showMessageDialog(null, "작성 완료되었습니다.");
																														postListView.setVisible(true);
																														postView.setVisible(false);
																														postWriteView.setVisible(false);
																														selectPostList();
																													} catch (Exception e1) {
																														// TODO Auto-generated catch block
																														e1.printStackTrace();
																													}
																								
																												} else {
																													// 글 번호가 있는 경우 update
																													System.out.println(Integer.parseInt(postNo));
																													System.out.println(postTitle);
																													System.out.println(postContent);
																													MemberPostVO vo = new MemberPostVO(Integer.parseInt(postNo), memberId, postTitle, postContent);
																													try {
																														postDAO.updatePost(vo);
																														JOptionPane.showMessageDialog(null, "수정 완료되었습니다.");
																														postListView.setVisible(true);
																														postView.setVisible(false);
																														postWriteView.setVisible(false);
																														selectPostList();
																													} catch (SQLException e1) {
																														// TODO Auto-generated catch block
																														e1.printStackTrace();
																													}
																								
																												}
																								
																											}
																										});
																										
																												postWriteView.setVisible(false);
																												
																												JLabel background3 = new JLabel("");
																												background3.setIcon(new ImageIcon(MemberBoothView.class.getResource("/img/background_2.jpeg")));
																												background3.setBounds(0, 0, 984, 657);
																												postWriteView.add(background3);

		listTableModel = new ListTableModel();
		selectPostList();

	}

	void selectPostList() {
		try {
			ArrayList list = postDAO.postList();
			listTableModel.data = list;
			tbPostList.setModel(listTableModel);
			listTableModel.fireTableDataChanged();

		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	void selectPostReplyList() {
		try {
			ArrayList list = postReplyDAO.postReplyList(Integer.parseInt(tfPostNo.getText()));
			listTableReplyModel.data = list;
			tblReplyList.setModel(listTableReplyModel);
			listTableReplyModel.fireTableDataChanged();

		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	// 테이블 모델 클래스
	class ListTableModel extends AbstractTableModel {
		ArrayList data = new ArrayList();
		String[] colNames = { "번호", "제목", "내용", "게시날짜", "작성자", "아이디" };

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

	class ListTableReplyModel extends AbstractTableModel {
		ArrayList data = new ArrayList();
//		String[] colNames = { "번호", "내용", "작성날짜", "작성자", "아이디" };
		String[] colNames = { "내용", "작성날짜", "작성자" };

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
