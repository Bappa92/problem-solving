import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

public class SerilizableObject implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static int a = 0;
	private int b = 20;
	private transient int c = 50;
	private int d = 100;

	@Override
	public String toString() {
		return "SerilizableObject [a=" + a + ",b=" + b + ",c=" + c + ",d=" + d + "]";
	}

	public static void main(String args[]) {
		SerilizableObject serilizableObject = new SerilizableObject();
		System.out.println(serilizableObject);
		
		// FileOutputStream fileOutputStream;
		// try {
		// fileOutputStream = new FileOutputStream("object.ser");
		//
		// ObjectOutputStream objectOutputStream = new
		// ObjectOutputStream(fileOutputStream);
		//
		// SerilizableObject serilizableObject = new SerilizableObject();
		// serilizableObject.a=50;
		// objectOutputStream.writeObject(serilizableObject);
		// objectOutputStream.close();
		// } catch (IOException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }

		try {
			
			FileInputStream fileInputStream = new FileInputStream("object.ser");
			ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
			SerilizableObject serilizableObject1 = (SerilizableObject) objectInputStream.readObject();
			System.out.println(serilizableObject1);
			objectInputStream.close();
		} catch (IOException | ClassNotFoundException ex) {
			ex.printStackTrace();
			;
		}
	}
}
