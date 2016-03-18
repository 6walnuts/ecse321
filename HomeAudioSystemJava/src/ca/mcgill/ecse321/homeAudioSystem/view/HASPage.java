package ca.mcgill.ecse321.homeAudioSystem.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.SqlDateModel;

import ca.mcgill.ecse321.homeAudioSystem.controller.HASController;
import ca.mcgill.ecse321.homeAudioSystem.controller.InvalidInputException;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.Calendar;
import java.util.Properties;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import java.awt.Color;

public class HASPage extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3682655918812380166L;
	private JPanel contentPane;
	private JTextField nameAlbumTextF;
	private JTextField genreTextF;

	private String albumName;
	private String albumGenre;
	private Date releaseDate;
	
	private JDatePickerImpl releaseDatePicker;
	
	private String error;
	private JLabel errorMessage;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HASPage frame = new HASPage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public HASPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton addAlbumB = new JButton("Add Album");
		addAlbumB.setVerticalAlignment(SwingConstants.TOP);
		
		addAlbumB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				HASController controller = new HASController();
				
				albumName = nameAlbumTextF.getText();
				albumGenre = genreTextF.getText();
				releaseDate = (java.sql.Date) releaseDatePicker.getModel().getValue();
				
				error = null;
				
				try{
					
					controller.addAlbum(albumName, albumGenre, releaseDate);
					
				} catch (Exception e1) {
					error = e1.getMessage();
				}
				refreshData();
			}
		});
		
		SqlDateModel model = new SqlDateModel();
		Properties p = new Properties();
		p.put("text.today", "Today");
		p.put("text.month", "Month");
		p.put("text.year", "Year");
		JDatePanelImpl datePanel = new JDatePanelImpl(model,p);
		releaseDatePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
		
		
		
		nameAlbumTextF = new JTextField();
		nameAlbumTextF.setColumns(10);
		
		JLabel lblAlbumName = new JLabel("Album Name");
		
		genreTextF = new JTextField();
		genreTextF.setColumns(10);
		
		JLabel lblGenre = new JLabel("Genre");
		
		JLabel lblReleaseDate = new JLabel("Release Date");
		
		errorMessage = new JLabel("");
		errorMessage.setForeground(Color.RED);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
									.addComponent(nameAlbumTextF, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
									.addComponent(addAlbumB, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addComponent(lblAlbumName))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(genreTextF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblGenre))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblReleaseDate)
								.addComponent(releaseDatePicker, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addComponent(errorMessage))
					.addContainerGap(85, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(13)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAlbumName)
						.addComponent(lblGenre)
						.addComponent(lblReleaseDate))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(nameAlbumTextF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(genreTextF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(releaseDatePicker, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(addAlbumB)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(errorMessage)
					.addContainerGap(146, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
		
		refreshData();
		pack();
		
	}
	
	private void refreshData()
	{
		errorMessage.setText(error);
		
		if(error == null|| error.length()==0)
		{
			releaseDatePicker.getModel().setValue(null);
		}
		
		
	}
}
