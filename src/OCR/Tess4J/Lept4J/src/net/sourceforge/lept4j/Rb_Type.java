package OCR.Tess4J.Lept4J.src.net.sourceforge.lept4j;
import com.sun.jna.Pointer;
import com.sun.jna.Union;
/**
 * <i>native declaration : rbtree.h:10</i><br>
 * This file was autogenerated by <a href="http://jnaerator.googlecode.com/">JNAerator</a>,<br>
 * a tool written by <a href="http://ochafik.com/">Olivier Chafik</a> that <a href="http://code.google.com/p/jnaerator/wiki/CreditsAndLicense">uses a few opensource projects.</a>.<br>
 * For help, please visit <a href="http://nativelibs4java.googlecode.com/">NativeLibs4Java</a> or <a href="http://jna.dev.java.net/">JNA</a>.
 */
public class Rb_Type extends Union {
	/** C type : l_int64 */
	public long itype;
	/** C type : l_uint64 */
	public long utype;
	/** C type : l_float64 */
	public double ftype;
	/** C type : void* */
	public Pointer ptype;
	public Rb_Type() {
		super();
	}
	/** @param itype_or_utype C type : l_int64, or C type : l_uint64 */
	public Rb_Type(long itype_or_utype) {
		super();
		this.utype = this.itype = itype_or_utype;
		setType(Long.TYPE);
	}
	/** @param ftype C type : l_float64 */
	public Rb_Type(double ftype) {
		super();
		this.ftype = ftype;
		setType(Double.TYPE);
	}
	/** @param ptype C type : void* */
	public Rb_Type(Pointer ptype) {
		super();
		this.ptype = ptype;
		setType(Pointer.class);
	}
	public static class ByReference extends Rb_Type implements com.sun.jna.Structure.ByReference {
		
	};
	public static class ByValue extends Rb_Type implements com.sun.jna.Structure.ByValue {
		
	};
}
