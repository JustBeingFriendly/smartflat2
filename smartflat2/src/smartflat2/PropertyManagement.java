package smartflat2;


import java.io.InputStream;

import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.SWT;


public class PropertyManagement extends Composite {

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public PropertyManagement(Composite parent, int style) {
		super(parent, style);
		setLayout(null);
		
		Display display = Display.getCurrent();
		InputStream inputCentennial = getClass().getResourceAsStream("Centennial.jpg");	
		InputStream inputDivision = getClass().getResourceAsStream("Division.jpg");	
		InputStream inputWorcester = getClass().getResourceAsStream("WorcesterB.jpg");	
		
		
		Button btnCentennial = new Button(this, SWT.BORDER | SWT.PUSH);
		btnCentennial.setText("New Button");
		btnCentennial.setBounds(197, 33, 439, 290);
		Image imageCentennial = new Image(display, inputCentennial);
		btnCentennial.setImage(imageCentennial);
		
		Button btnDivision = new Button(this, SWT.BORDER | SWT.FLAT);
		btnDivision.setText("New Button");
		btnDivision.setBounds(664, 33, 439, 290);
		Image imageDivision = new Image(display, inputDivision);
		btnDivision.setImage(imageDivision);
		
		Button btnWorcester = new Button(this, SWT.BORDER | SWT.FLAT);
		btnWorcester.setText("New Button");
		btnWorcester.setBounds(416, 331, 439, 280);		
		Image imageWorcester = new Image(display, inputWorcester);
		btnWorcester.setImage(imageWorcester);

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
	
	private Image imageResize(Display display, InputStream input){
		
		Image image = new Image(display, input);
		double oldWidth = image.getBounds().width;
		double oldHeight = image.getBounds().height;
		double newWidth = oldWidth * 0.5;
		double newHeight = oldHeight * 0.5;
		
		
		ImageData imageData = image.getImageData();
		imageData.scaledTo((int)newWidth,(int) newHeight);
		Image imageResized = new Image(display, imageData);
		image.dispose();
		return imageResized;
	}
}
