package run.admin.movie.ex;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import movieinfo.MovieInfoManager;
import java.awt.SystemColor;

public class ExAdd extends JFrame{
	private JTextField movieText;
	private JTextField directorText;
	private JTextField actorText;
	private JTextField showText;
	private JTextField imgText;
   
	public ExAdd() {
	
	setTitle("영화 추가");

    
    JPanel searchP = new JPanel();
    searchP.setBackground(new Color(153, 50, 204));
    searchP.setLayout(null);
    setContentPane(searchP);
    
    JPanel panel = new JPanel();
    panel.setBackground(Color.WHITE);
    panel.setBounds(12, 42, 560, 395);
    searchP.add(panel);
    panel.setLayout(null);
    
    JLabel title = new JLabel("상영예정영화 추가");
    title.setFont(new Font("굴림", Font.BOLD, 12));
    title.setHorizontalAlignment(SwingConstants.CENTER);
    title.setBounds(178, 10, 200, 25);
    panel.add(title);
    
    JLabel movieLabel = new JLabel("영화 제목 :");
    movieLabel.setHorizontalAlignment(SwingConstants.RIGHT);
    movieLabel.setBounds(12, 50, 80, 25);
    panel.add(movieLabel);
    
    JLabel storyLabel = new JLabel("줄거리 :");
    storyLabel.setHorizontalAlignment(SwingConstants.RIGHT);
    storyLabel.setBounds(12, 90, 80, 25);
    panel.add(storyLabel);
    
    movieText = new JTextField(20);
    movieText.setBounds(112, 50, 395, 25);
    panel.add(movieText);
    
    JButton btnAdd = new JButton("추가");
    btnAdd.setBounds(12, 358, 536, 25);
    panel.add(btnAdd);
    
    JLabel directorLabel = new JLabel("감독 :");
    directorLabel.setHorizontalAlignment(SwingConstants.RIGHT);
    directorLabel.setBounds(12, 253, 80, 25);
    panel.add(directorLabel);
    
    JLabel actorLabel = new JLabel("배우 :");
    actorLabel.setHorizontalAlignment(SwingConstants.RIGHT);
    actorLabel.setBounds(12, 288, 80, 25);
    panel.add(actorLabel);
    
    JLabel imgLabel = new JLabel("이미지경로 :");
    imgLabel.setHorizontalAlignment(SwingConstants.RIGHT);
    imgLabel.setBounds(12, 323, 80, 25);
    panel.add(imgLabel);
    
    directorText = new JTextField(20);
    directorText.setBounds(112, 255, 395, 25);
    panel.add(directorText);
    
    actorText = new JTextField(20);
    actorText.setBounds(112, 290, 395, 25);
    panel.add(actorText);
    
    imgText = new JTextField(20);
    imgText.setBounds(112, 325, 395, 25);
    panel.add(imgText);
    
    JTextArea storyText = new JTextArea();
    storyText.setBackground(SystemColor.control);
    storyText.setBounds(112, 90, 395, 155);
    panel.add(storyText);
    
    btnAdd.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			MovieInfoManager movie = new MovieInfoManager();
			if(movie.ExInsert(movieText.getText(),storyText.getText(),directorText.getText(),actorText.getText(),imgText.getText())) {
				JOptionPane.showMessageDialog(null, "성공");
			}else {
				JOptionPane.showMessageDialog(null, "실패");
			}
			
		}
	});
    
    setBounds(200, 200, 590, 477);
    setResizable(false);
    setVisible(true);
    }

}