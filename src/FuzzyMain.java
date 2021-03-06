/**
 * @author Percy
 * Reference: http://scarcitycomputing.blogspot.com/2013/04/damerau-levenshtein-edit-distance.html
 */
public class FuzzyMain {

    @SuppressWarnings("Duplicates")
    public static void main(String [] args) {
        FuzzyContext fc = new FuzzyContext();

        fc.setF(new Levenshtein());
        System.out.println(fc.fuzzy("tomato","potato"));
        System.out.println(fc.fuzzy("ha ha ha ab","ha ha ha ba"));
        System.out.println(fc.fuzzy("a cat","an act"));

        fc.setF(new Damerau_Levenshtein());
        System.out.println(fc.fuzzy("tomato","potato"));
        System.out.println(fc.fuzzy("ha ha ha ab","ha ha ha ba"));
        System.out.println(fc.fuzzy("a cat","an act"));
    }

}
