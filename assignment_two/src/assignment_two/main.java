package assignment_two;
import java.util.Scanner;

/** =================================================================
*   main Class
*   ===============================================================*/
public class main {

    /** ----------------------------------------------------------------
  	*   Start global variables
  	*   ---------------------------------------------------------------*/
  	static Scanner keyboard = new Scanner(System.in);
  	private static int mainInput;
  	private static int subInput;
    private static String stringInput;
  	private static Book bookOb;
    static BST<String, Integer> st;
    static RedBlackBST<String, Object> rb;

    /** ----------------------------------------------------------------
  	*   Start Methods
  	*   ---------------------------------------------------------------*/

    /** ----------------------------------------------------------------
  	*   welcomeMessage - display message, get initial input
  	*		@return input
  	*   ---------------------------------------------------------------*/
  	private static int welcomeMessage() {
  			System.out.println("\nAssignment 2.\n\n\tEnter '0' to exit.\n\tEnter '1' to create binary search tree.\n\tEnter '2' to create red-black tree.");
  			System.out.print("\n>\t");
  		 	return getInput();
  	}

    /** ----------------------------------------------------------------
  	*   BESTMessage - display BST message, get initial input
  	*		@return input
  	*   ---------------------------------------------------------------*/
  	private static int BSTMessage() {
  			System.out.print("\nBST Analysis: \n\n\tEnter '0' to return to main menu.\n\tEnter '1' to add.\n\tEnter '2' to remove.\n\tEnter '3' to search.\n\tEnter '4' for inOrder traversal.\n\tEnter '5' for preOrder traversal.\n\tEnter '6' for postOrder traversal.\n");
  			System.out.print("\n>\t");
  		 	return getInput();
  	}

    /** ----------------------------------------------------------------
  	*   RedBlackMessage - display message, get initial input
  	*		@return input
  	*   ---------------------------------------------------------------*/
  	private static int RedBlackMessage() {
  			System.out.print("\nRed-Black Tree Analysis: \n\n\tEnter '0' to return to main menu.\n\tEnter '1' to add.\n\tEnter '2' to remove.\n\tEnter '3' to search.\n\tEnter '4' for inOrder traversal.\n\tEnter '5' for preOrder traversal.\n\tEnter '6' for postOrder traversal.\n");
  			System.out.print("\n>\t");
  		 	return getInput();
  	}

    /** ----------------------------------------------------------------
  	*   getInput - resets keyboard input
  	*		@return input
  	*   ---------------------------------------------------------------*/
  	private static int getInput() {
  			return keyboard.nextInt();
  	}
  	
    /** ----------------------------------------------------------------
  	*   getInput - resets keyboard input
  	*		@return input
  	*   ---------------------------------------------------------------*/
  	private static String getString() {
  			return keyboard.next();
  	}

    /** ----------------------------------------------------------------
  	*   createBST - create binary search tree
  	*   @param capacity
  	*   ---------------------------------------------------------------*/
  	private static void createBST(int capacity) {
        st = new BST<String, Integer>();
  			System.out.println("\nCreating binary search tree of '" + capacity + "' elements.");

  			// add x items to tree
  			for (int i = 0; i < capacity; i++) {
            st.put("Key " + i, i);
  			}
  	}

    /** ----------------------------------------------------------------
  	*   createRedBlack - create red black tree
  	*   @param capacity
  	*   ---------------------------------------------------------------*/
  	private static void createRedBlack(int capacity) {
        rb = new RedBlackBST<String, Object>();
  			System.out.println("\nCreating red black binary search tree of '" + capacity + "' elements.");

  			// add x items to tree
  			for (int i = 0; i < capacity; i++) {
  				Book bookOb = new Book(i);
            	rb.put("Key " + i, bookOb);
  			}
  	}

  	/** ----------------------------------------------------------------
  	*   main - start tests
  	*   ---------------------------------------------------------------*/
    public static void main(String[] args) {

        // get input
  			mainInput = welcomeMessage();

        // execute commands until exiting
  			while (mainInput != 0) {

            // BST analysis
    				if (mainInput == 1) {
                // create initial tree
                System.out.print(">\tEnter binary search tree capacity (integer): \t");
                createBST(getInput());

                // get next command
                subInput = BSTMessage();

                while (subInput != 0) {
                      // add
                      if (subInput == 1) {
                          System.out.print(">\tEnter item to add: \t");
                          subInput = getInput();
                          st.put("Key " + subInput, subInput);
                          subInput = BSTMessage();
                      }
                      // remove
                      else if (subInput == 2) {
                    	    System.out.print(">\tEnter key to remove: \t");
                          st.delete("Key " + getInput());
                          subInput = BSTMessage();
                      }
                      // search
                      else if (subInput == 3) {
                          System.out.print(">\tEnter key to search: \t");
                          System.out.println("\nReturning: Key " + st.get("Key " + getInput()));
                          subInput = BSTMessage();
                      }
                      // inOrder traverse
                      else if (subInput == 4) {
                    	  st.printInorder();
                    	  subInput = BSTMessage();
                      }
                      // preOrder traverse
                      else if (subInput == 5) {
                    	  st.printPreorder();
                    	  subInput = BSTMessage();
                      }
                      // postOrder traverse
                      else if (subInput == 6) {
                        st.printPostorder();
                        subInput = BSTMessage();
                      }
                      // error
                      else {
                          System.out.println("\n>\tInvalid input value.");
                          subInput = BSTMessage();
                      }
                }
                // update main input
                mainInput = welcomeMessage();
            }
            // Red Black tree
            else if (mainInput == 2) {
              // create initial tree
              System.out.print(">\tEnter red black search tree capacity (integer): \t");
              createRedBlack(getInput());

              // get next command
              subInput = RedBlackMessage();

              while (subInput != 0) {
                    // add
                    if (subInput == 1) {
                        System.out.print(">\tEnter ID number to add: \t");
                        subInput = getInput();
                        System.out.print("\n>\tEnter Author name to add: \t");
                        String author = getString();
                        // ID, Author, Title
                        Book bookOb = new Book(subInput, author);
                        // add object to tree
                        rb.put("Key " + subInput, bookOb);
                        subInput = BSTMessage();
                    }
                    // remove
                    else if (subInput == 2) {
                        System.out.print(">\tEnter key to remove: \t");
                        rb.delete("Key " + getInput());
                        subInput = BSTMessage();
                    }
                    // search
                    else if (subInput == 3) {
                        System.out.print(">\tEnter key to search: \t");
                        bookOb = (Book) rb.get("Key " + getInput());
                        System.out.println("Returning key: " + bookOb.getID());
                        bookOb.print();
                        subInput = BSTMessage();
                    }
                    // inOrder traverse
                    else if (subInput == 4) {
                      rb.printInorder();
                      subInput = BSTMessage();
                    }
                    // preOrder traverse
                    else if (subInput == 5) {
                      rb.printPreorder();
                      subInput = BSTMessage();
                    }
                    // postOrder traverse
                    else if (subInput == 6) {
                      rb.printPostorder();
                      subInput = BSTMessage();
                    }
                    // error
                    else {
                        System.out.println("\n>\tInvalid input value.");
                        subInput = BSTMessage();
                    }
              }
              // update main input
              mainInput = welcomeMessage();
            }
            // error
            else {
              System.out.println("\n>\tInvalid input value.");
              // update main input
              mainInput = welcomeMessage();
            }

        };
    }
}
