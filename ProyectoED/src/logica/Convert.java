package logica;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Convert {
	public static byte[] toBytes(Object object) throws IOException {
		try (ByteArrayOutputStream bos = new ByteArrayOutputStream(); 
				ObjectOutputStream oos = new ObjectOutputStream(bos)) {
			oos.writeObject(object);
			return bos.toByteArray();
		}
	}

	public static Object toObject(byte[] bytes) throws IOException, ClassNotFoundException {
		try (ByteArrayInputStream bis = new ByteArrayInputStream(bytes); 
				ObjectInputStream ois = new ObjectInputStream(bis)) {
			return ois.readObject();
		}
	}
}
