package OCR.Tess4J.Lept4J.src.net.sourceforge.lept4j;
import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import java.util.Arrays;
import java.util.List;
/**
 * <i>native declaration : jbclass.h:42</i><br>
 * This file was autogenerated by <a href="http://jnaerator.googlecode.com/">JNAerator</a>,<br>
 * a tool written by <a href="http://ochafik.com/">Olivier Chafik</a> that <a href="http://code.google.com/p/jnaerator/wiki/CreditsAndLicense">uses a few opensource projects.</a>.<br>
 * For help, please visit <a href="http://nativelibs4java.googlecode.com/">NativeLibs4Java</a> or <a href="http://jna.dev.java.net/">JNA</a>.
 */
public class JbData extends Structure {
	/**
	 * template composite for all classes<br>
	 * C type : Pix*
	 */
	public net.sourceforge.lept4j.Pix.ByReference pix;
	/**
	 * number of pages<br>
	 * C type : l_int32
	 */
	public int npages;
	/**
	 * max width of original page images<br>
	 * C type : l_int32
	 */
	public int w;
	/**
	 * max height of original page images<br>
	 * C type : l_int32
	 */
	public int h;
	/**
	 * number of classes<br>
	 * C type : l_int32
	 */
	public int nclass;
	/**
	 * lattice width for template composite<br>
	 * C type : l_int32
	 */
	public int latticew;
	/**
	 * lattice height for template composite<br>
	 * C type : l_int32
	 */
	public int latticeh;
	/**
	 * array of class ids for each component<br>
	 * C type : Numa*
	 */
	public net.sourceforge.lept4j.Numa.ByReference naclass;
	/**
	 * array of page nums for each component<br>
	 * C type : Numa*
	 */
	public net.sourceforge.lept4j.Numa.ByReference napage;
	/**
	 * array of UL corners at which the<br>
	 * C type : Pta*
	 */
	public net.sourceforge.lept4j.Pta.ByReference ptaul;
	public JbData() {
		super();
	}
	protected List<? > getFieldOrder() {
		return Arrays.asList("pix", "npages", "w", "h", "nclass", "latticew", "latticeh", "naclass", "napage", "ptaul");
	}
	public JbData(Pointer peer) {
		super(peer);
		read();
	}
	public static class ByReference extends JbData implements Structure.ByReference {
		
	};
	public static class ByValue extends JbData implements Structure.ByValue {
		
	};
}