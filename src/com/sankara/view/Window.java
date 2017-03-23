package com.sankara.view;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;

import com.sankara.model.Watch;
import com.sankara.observer.Observer;

public class Window extends JFrame {
	
	private JLabel label = new JLabel();
	private Watch watch;
	
	public Window() {
		
		this.setTitle("Time is the Essence");
		this.setSize(200, 80);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		
		this.watch = new Watch();
		
		this.watch.addObserver(new Observer() {	
			@Override
			public void update(String hour) {
				label.setText(hour);			
			}
		});
		
		Font police = new Font("DS-digital", Font.TYPE1_FONT, 30);
		this.label.setFont(police);
		this.label.setHorizontalAlignment(JLabel.CENTER);
		
		this.getContentPane().add(label, BorderLayout.CENTER);
		this.setVisible(true);
		this.watch.run();
	}

}
