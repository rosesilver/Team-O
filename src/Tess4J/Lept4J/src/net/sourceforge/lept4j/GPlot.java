package OCR.Tess4J.Lept4J.src.net.sourceforge.lept4j;
import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import java.util.Arrays;
import java.util.List;
/**
 * Data structure for generating gnuplot files<br>
 * <i>native declaration : gplot.h:43</i><br>
 * This file was autogenerated by <a href="http://jnaerator.googlecode.com/">JNAerator</a>,<br>
 * a tool written by <a href="http://ochafik.com/">Olivier Chafik</a> that <a href="http://code.google.com/p/jnaerator/wiki/CreditsAndLicense">uses a few opensource projects.</a>.<br>
 * For help, please visit <a href="http://nativelibs4java.googlecode.com/">NativeLibs4Java</a> or <a href="http://jna.dev.java.net/">JNA</a>.
 */
public class GPlot extends Structure {
	/**
	 * for cmd, data, output<br>
	 * C type : char*
	 */
	public Pointer rootname;
	/**
	 * command file name<br>
	 * C type : char*
	 */
	public Pointer cmdname;
	/**
	 * command file contents<br>
	 * C type : Sarray*
	 */
	public Sarray.ByReference cmddata;
	/**
	 * data file names<br>
	 * C type : Sarray*
	 */
	public Sarray.ByReference datanames;
	/**
	 * plot data (1 string/file)<br>
	 * C type : Sarray*
	 */
	public Sarray.ByReference plotdata;
	/**
	 * title for each individual plot<br>
	 * C type : Sarray*
	 */
	public Sarray.ByReference plottitles;
	/**
	 * plot style for individual plots<br>
	 * C type : Numa*
	 */
	public net.sourceforge.lept4j.Numa.ByReference plotstyles;
	/**
	 * current number of plots<br>
	 * C type : l_int32
	 */
	public int nplots;
	/**
	 * output file name<br>
	 * C type : char*
	 */
	public Pointer outname;
	/**
	 * GPLOT_OUTPUT values<br>
	 * C type : l_int32
	 */
	public int outformat;
	/**
	 * GPLOT_SCALING values<br>
	 * C type : l_int32
	 */
	public int scaling;
	/**
	 * optional<br>
	 * C type : char*
	 */
	public Pointer title;
	/**
	 * optional x axis label<br>
	 * C type : char*
	 */
	public Pointer xlabel;
	/**
	 * optional y axis label<br>
	 * C type : char*
	 */
	public Pointer ylabel;
	public GPlot() {
		super();
	}
	protected List<? > getFieldOrder() {
		return Arrays.asList("rootname", "cmdname", "cmddata", "datanames", "plotdata", "plottitles", "plotstyles", "nplots", "outname", "outformat", "scaling", "title", "xlabel", "ylabel");
	}
	public GPlot(Pointer peer) {
		super(peer);
		read();
	}
	public static class ByReference extends GPlot implements Structure.ByReference {
		
	};
	public static class ByValue extends GPlot implements Structure.ByValue {
		
	};
}