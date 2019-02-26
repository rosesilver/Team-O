package OCR.Tess4J.Lept4J.src.net.sourceforge.lept4j;
import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import java.util.Arrays;
import java.util.List;
/**
 * Basic rectangle<br>
 * <i>native declaration : pix.h:97</i><br>
 * This file was autogenerated by <a href="http://jnaerator.googlecode.com/">JNAerator</a>,<br>
 * a tool written by <a href="http://ochafik.com/">Olivier Chafik</a> that <a href="http://code.google.com/p/jnaerator/wiki/CreditsAndLicense">uses a few opensource projects.</a>.<br>
 * For help, please visit <a href="http://nativelibs4java.googlecode.com/">NativeLibs4Java</a> or <a href="http://jna.dev.java.net/">JNA</a>.
 */
public class Box extends Structure {
	/**
	 * left coordinate<br>
	 * C type : l_int32
	 */
	public int x;
	/**
	 * top coordinate<br>
	 * C type : l_int32
	 */
	public int y;
	/**
	 * box width<br>
	 * C type : l_int32
	 */
	public int w;
	/**
	 * box height<br>
	 * C type : l_int32
	 */
	public int h;
	/**
	 * reference count (1 if no clones)<br>
	 * C type : l_uint32
	 */
	public int refcount;
	public Box() {
		super();
	}
	protected List<? > getFieldOrder() {
		return Arrays.asList("x", "y", "w", "h", "refcount");
	}
	/**
	 * @param x left coordinate<br>
	 * C type : l_int32<br>
	 * @param y top coordinate<br>
	 * C type : l_int32<br>
	 * @param w box width<br>
	 * C type : l_int32<br>
	 * @param h box height<br>
	 * C type : l_int32<br>
	 * @param refcount reference count (1 if no clones)<br>
	 * C type : l_uint32
	 */
	public Box(int x, int y, int w, int h, int refcount) {
		super();
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		this.refcount = refcount;
	}
	public Box(Pointer peer) {
		super(peer);
                read();
	}
	public static class ByReference extends Box implements Structure.ByReference {
		
	};
	public static class ByValue extends Box implements Structure.ByValue {
		
	};
}
