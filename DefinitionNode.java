import java.util.ArrayList;
import java.util.Collections;

public class DefinitionNode {
    private final String word;      // the word this definition defines
    private final String meaning;   // the meaning of that word    
    private DefinitionNode leftChild;   // nodes preceding this one alphabetically
    private DefinitionNode rightChild;  // nodes following this one alphabetically
     
    /**
     * Constructs a DefinitionNode with the specified word and meaning.
     * @param word The word associated with this definition
     * @param meaning The meaning of that word
     * @throws IllegalArgumentException when the word or meaning are either
     *         references to an empty string or null references.
     */
    public DefinitionNode(String word, String meaning) { 
        if (word == null || meaning == null) {
            throw new IllegalArgumentException();
        }
        if (word == "" || meaning == "") {
            throw new IllegalArgumentException();
        }
        this.word = word;
        this.meaning = meaning;
    }
     
    /**
     * This helper method inserts a new node into the tree or subtree that is 
     * rooted at this node.  If it cannot directly add the new node as a child 
     * of this node, then it must recursively call this method on its appropriate
     * child, to eventually complete this insertion.
     * @param newNode The new node that is being inserted into the tree
     * @throws IllegalArgumentException when the word inside newNode is already in
     *         the tree.  Multiple definitions for the same word are not allowed.
     */
    public void insertHelper(DefinitionNode newNode) throws IllegalArgumentException {
        if (newNode.word.compareTo(this.word) < 0) {
            if (this.leftChild == null) {
               this.leftChild = newNode;
            }
            else {
                leftChild.insertHelper(newNode);
            }
        }
        else if (newNode.word.compareTo(this.word) > 0) {
            if (this.rightChild == null) {
                this.rightChild = newNode;
            }
            else {
                rightChild.insertHelper(newNode);
            }
        }
        if (newNode.word.equals(this.word)) {
            throw new IllegalArgumentException();
        }
    }
     
    /**
     * This helper method retrieves the meaning of a particular word from the
     * tree or subtree rooted at this node.  Like the insertHelper method above, 
     * this method should also be defined recursively.
     * @param word The word associated with the meaning being looked up
     * @return The meaning of that word, or null if the word is not found
     */
    public String lookupHelper(String word) {
        String temp = null; 
        if (word.equals(this.word)) {
            temp = this.meaning;
        } 
        if (word.compareTo(this.word) < 0) {
            if (this.leftChild == null) {
               return null;
            }
            else {
                temp = leftChild.lookupHelper(word);
            }
        }
        else if (word.compareTo(this.word) > 0) {
            if (this.rightChild == null) {
                return null;
            }
            else {
                temp = rightChild.lookupHelper(word);
            }
        }
        return temp;
    }
     
    /**
     * This recursive helper method retrieves the number of words in the tree
     * or subtree rooted at this node.
     * @return The number of definitions in this tree or subtree
     */
    public int getWordCountHelper() {
        if (this.word != null) {
            if (leftChild == null && rightChild == null) {
                return 1;
            }
            if (leftChild == null && rightChild != null) {
                return 1 + rightChild.getWordCountHelper();
            }
            if (leftChild != null && rightChild == null) {
                return 1 + leftChild.getWordCountHelper();
            }
            if (leftChild != null && rightChild != null) {
                return 1 + leftChild.getWordCountHelper() + rightChild.getWordCountHelper();
            }
            return 0;
        }       
        else {
            return 0;
        }
    }  
     
    /**
     * This recursive helper method retrieves a list containing all of the
     * words in the tree or subtree rooted at this node.
     * @return The list of all words in this words tree or subtree
     */
    public ArrayList<String> getAllWordsHelper() { 
        ArrayList<String> s = new ArrayList<String>();
        if (word != null) {
            s.add(word);
        }
        if (leftChild != null) {
            s.addAll(leftChild.getAllWordsHelper());
        }
        if (rightChild != null) {
            s.addAll(rightChild.getAllWordsHelper());
        }
        Collections.sort(s, String.CASE_INSENSITIVE_ORDER);
        return s;
    }
}
