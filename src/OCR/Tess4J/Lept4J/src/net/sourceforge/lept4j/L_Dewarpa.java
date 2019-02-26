package OCR.Tess4J.Lept4J.src.net.sourceforge.lept4j;
import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import com.sun.jna.ptr.PointerByReference;
import java.util.Arrays;
import java.util.List;
/**
 * Data structure to hold a number of Dewarp<br>
 * <i>native declaration : dewarp.h:19</i><br>
 * This file was autogenerated by <a href="http://jnaerator.googlecode.com/">JNAerator</a>,<br>
 * a tool written by <a href="http://ochafik.com/">Olivier Chafik</a> that <a href="http://code.google.com/p/jnaerator/wiki/CreditsAndLicense">uses a few opensource projects.</a>.<br>
 * For help, please visit <a href="http://nativelibs4java.googlecode.com/">NativeLibs4Java</a> or <a href="http://jna.dev.java.net/">JNA</a>.
 */
public class L_Dewarpa extends Structure {
	/**
	 * size of dewarp ptr array<br>
	 * C type : l_int32
	 */
	public int nalloc;
	/**
	 * maximum page number in array<br>
	 * C type : l_int32
	 */
	public int maxpage;
	/**
	 * array of ptrs to page dewarp<br>
	 * C type : L_Dewarp**
	 */
	public PointerByReference dewarp;
	/**
	 * array of ptrs to cached dewarps<br>
	 * C type : L_Dewarp**
	 */
	public PointerByReference dewarpcache;
	/**
	 * list of page numbers for pages<br>
	 * C type : Numa*
	 */
	public net.sourceforge.lept4j.Numa.ByReference namodels;
	/**
	 * list of page numbers with either<br>
	 * C type : Numa*
	 */
	public net.sourceforge.lept4j.Numa.ByReference napages;
	/**
	 * reduction factor of input: 1 or 2<br>
	 * C type : l_int32
	 */
	public int redfactor;
	/**
	 * disparity arrays sampling factor<br>
	 * C type : l_int32
	 */
	public int sampling;
	/**
	 * min number of long lines required<br>
	 * C type : l_int32
	 */
	public int minlines;
	/**
	 * max distance for getting ref page<br>
	 * C type : l_int32
	 */
	public int maxdist;
	/**
	 * maximum abs line curvature<br>
	 * C type : l_int32
	 */
	public int max_linecurv;
	/**
	 * minimum abs diff line<br>
	 * C type : l_int32
	 */
	public int min_diff_linecurv;
	/**
	 * maximum abs diff line<br>
	 * C type : l_int32
	 */
	public int max_diff_linecurv;
	/**
	 * maximum abs left or right edge<br>
	 * C type : l_int32
	 */
	public int max_edgeslope;
	/**
	 * maximum abs left or right edge<br>
	 * C type : l_int32
	 */
	public int max_edgecurv;
	/**
	 * maximum abs diff left-right<br>
	 * C type : l_int32
	 */
	public int max_diff_edgecurv;
	/**
	 * use both disparity arrays if<br>
	 * C type : l_int32
	 */
	public int useboth;
        /**
	 * if there are multiple columns,<br>
	 * C type : l_int32
	 */
	public int check_columns;
	/**
	 * invalid models have been removed<br>
	 * C type : l_int32
	 */
	public int modelsready;
	public L_Dewarpa() {
		super();
	}
	protected List<? > getFieldOrder() {
		return Arrays.asList("nalloc", "maxpage", "dewarp", "dewarpcache", "namodels", "napages", "redfactor", "sampling", "minlines", "maxdist", "max_linecurv", "min_diff_linecurv", "max_diff_linecurv", "max_edgeslope", "max_edgecurv", "max_diff_edgecurv", "useboth", "check_columns", "modelsready");
	}
	public L_Dewarpa(Pointer peer) {
		super(peer);
		read();
	}
	public static class ByReference extends L_Dewarpa implements Structure.ByReference {
		
	};
	public static class ByValue extends L_Dewarpa implements Structure.ByValue {
		
	};
}
