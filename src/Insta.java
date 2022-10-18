import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
public class Insta extends JFrame{
	public Insta() {
	}
	
	PhotoMethodsHolder imageLibrary; //used to store photos
	JPanel panel, panelBottom; 
	JButton previousButton, nextButton; 
	JLabel label, title, caption; 
	
	//used to select ratings for the displayed photos
	JRadioButton ratingOne;
	JRadioButton ratingTwo;
	JRadioButton ratingThree;
	JRadioButton ratingFour;
	JRadioButton ratingFive;
	
	int currentIndex = 0;
	
	//imageLibrary Getter
	public PhotoMethodsHolder getImageLibrary() {
		return imageLibrary;
	}
	//imageLibrary Setter
	public void setImageLibrary(PhotoMethodsHolder imageLibrary) {
		this.imageLibrary = imageLibrary;
	}
	
	//This method adds components to the panel.
	public void addComponentsToPane(Container pane) {
		panel = new JPanel();
		
		panel.setLayout(new BorderLayout());
		
		getContentPane().add(panel, BorderLayout.CENTER);
		
		Insta myViewer = new Insta();
		
		// Getting the data of the given image file
		Photos p1 = new Photos("Deer.jpg", "Deer in my backyard!", "2021-05-09", 4);
		p1.loadImageData("Deer.jpg");

		Photos p2 = new Photos("Pig.jpg", "Meet my pet pig Pinky <3", "2021-09-09", 2);
		p2.loadImageData("Pig.jpg");

		Photos p3 = new Photos("Monkey.jpg", "Workig on my wild life photography skills :)", "2021-01-09", 1);
		p3.loadImageData("Monkey.jpg");
		
		// adding Photos to the image library
		myViewer.setImageLibrary(new Libraries(" Library of Photos ", 99));
		myViewer.getImageLibrary().addPhoto(p1);
		myViewer.getImageLibrary().addPhoto(p2);
		myViewer.getImageLibrary().addPhoto(p3);
		
		panelBottom = new JPanel();

		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(panelBottom, BorderLayout.SOUTH); 
		

		ratingOne = new JRadioButton("1");
		ratingTwo = new JRadioButton("2");
		ratingThree = new JRadioButton("3");
		ratingFour = new JRadioButton("4");
		ratingFive = new JRadioButton("5");
		
		// radiobuttons added to the bottom panel
		panelBottom.add(ratingOne);
		panelBottom.add(ratingTwo);
		panelBottom.add(ratingThree);
		panelBottom.add(ratingFour);
		panelBottom.add(ratingFive);

		ButtonGroup group = new ButtonGroup();
		group.add(ratingOne);
		group.add(ratingTwo);
		group.add(ratingThree);
		group.add(ratingFour);
		group.add(ratingFive);
		
		//gets rating for the default photo
		int ratingPicture = myViewer.getImageLibrary().getPhotos().get(0).getRating();
		
		//sets rating for default photo 
		if (ratingPicture == 1) {
			ratingOne.setSelected(true);
		} else if (ratingPicture == 2) {
			ratingTwo.setSelected(true);
		} else if (ratingPicture == 3) {
			ratingThree.setSelected(true);
		} else if (ratingPicture == 4) {
			ratingFour.setSelected(true);
		} else if (ratingPicture == 5) {
			ratingFive.setSelected(true);
		}

		//Displays default image
		ImageIcon photo1 = new ImageIcon(myViewer.getImageLibrary().getPhotos().get(0).getImageData()); 
	
		label = new JLabel(photo1, SwingConstants.CENTER);

		label.setIcon(photo1);
		
		title = new JLabel(myViewer.getImageLibrary().getPhotos().get(0).getFilename(), SwingConstants.CENTER);
		
		caption = new JLabel(myViewer.getImageLibrary().getPhotos().get(0).getCaption(), SwingConstants.CENTER);
		
		//method to give action to the next button
		class NextButtonListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {

				currentIndex++; 
				
				/*if the current index is equal to the size of the photos array list then the current index
				 * resets to 0
				 */
				if (currentIndex == myViewer.getImageLibrary().getPhotos().size()) {
					currentIndex = 0;
				}
				ImageIcon diffIndex = new ImageIcon(
						myViewer.getImageLibrary().getPhotos().get(currentIndex).getImageData()); 
				label.setIcon(diffIndex);
				title.setText(myViewer.getImageLibrary().getPhotos().get(currentIndex).getFilename()); 
				caption.setText(myViewer.getImageLibrary().getPhotos().get(currentIndex).getCaption()); 
				
				//sets the rating of the image being shown
				int ratingPicture = myViewer.getImageLibrary().getPhotos().get(currentIndex).getRating();
				
				if (ratingPicture == 1) {
					ratingOne.setSelected(true);
				} else if (ratingPicture == 2) {
					ratingTwo.setSelected(true);
				} else if (ratingPicture == 3) {
					ratingThree.setSelected(true);
				} else if (ratingPicture == 4) {
					ratingFour.setSelected(true);
				} else if (ratingPicture == 5) {
					ratingFive.setSelected(true);
				}
			}
		}

		//method to give actions to the previous button
		class PreviousButtonListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				currentIndex--; 
				
				//if the current index is less than 0 then current index resets to the last index 
				if (currentIndex < 0) {
					currentIndex = myViewer.getImageLibrary().getPhotos().size() - 1;
				}
				ImageIcon diffIndex = new ImageIcon(
						myViewer.getImageLibrary().getPhotos().get(currentIndex).getImageData()); 
				label.setIcon(diffIndex); 
				title.setText(myViewer.getImageLibrary().getPhotos().get(currentIndex).getFilename()); 
				caption.setText(myViewer.getImageLibrary().getPhotos().get(currentIndex).getCaption()); 
				
				//sets rating of image 
				int ratingPicture = myViewer.getImageLibrary().getPhotos().get(currentIndex).getRating();

				if (ratingPicture == 1) {
					ratingOne.setSelected(true);
				} else if (ratingPicture == 2) {
					ratingTwo.setSelected(true);
				} else if (ratingPicture == 3) {
					ratingThree.setSelected(true);
				} else if (ratingPicture == 4) {
					ratingFour.setSelected(true);
				} else if (ratingPicture == 5) {
					ratingFive.setSelected(true);
				}

			}

		}

		/**
		 * this method gives the radio buttons the action to change the rating of the photo and permanently
		 * set the rating to the changed rating
		 */
		class radioButtonListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				if (ratingOne.isSelected()) {
					myViewer.getImageLibrary().getPhotos().get(currentIndex).setRating(1);  
				} else if (ratingTwo.isSelected()) {
					myViewer.getImageLibrary().getPhotos().get(currentIndex).setRating(2);
				} else if (ratingThree.isSelected()) {
					myViewer.getImageLibrary().getPhotos().get(currentIndex).setRating(3);
				} else if (ratingFour.isSelected()) {
					myViewer.getImageLibrary().getPhotos().get(currentIndex).setRating(4);
				} else if (ratingFive.isSelected()) {
					myViewer.getImageLibrary().getPhotos().get(currentIndex).setRating(5);
				}

			}

		}
		
		
		panel.add(this.label);
		panel.add(title, BorderLayout.NORTH); 
		panel.add(caption, BorderLayout.SOUTH); 
	
		previousButton = new JButton("<");
		previousButton.addActionListener(new PreviousButtonListener());
		panel.add(previousButton, BorderLayout.WEST);

		nextButton = new JButton(">");
		nextButton.addActionListener(new NextButtonListener());
		panel.add(nextButton, BorderLayout.EAST);
		
		ratingOne.addActionListener(new radioButtonListener());
		ratingTwo.addActionListener(new radioButtonListener());
		ratingThree.addActionListener(new radioButtonListener());
		ratingFour.addActionListener(new radioButtonListener());
		ratingFive.addActionListener(new radioButtonListener());
		
		pane.add(panel);

	}
	
	//This methods created the GUI, 
	private void createAndShowGUI() {
		setTitle("\"Instagram\""); 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // what the 'x' button does
		setSize(900, 700);
		setLocationRelativeTo(null);

		addComponentsToPane(getContentPane());

		setVisible(true); 

	}
	
	public static void main(String[] args) {
		Insta myViewer = new Insta();

		myViewer.createAndShowGUI(); //displays all the components
	}

}
