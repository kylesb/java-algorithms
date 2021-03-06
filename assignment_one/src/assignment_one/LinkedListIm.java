package assignment_one;

/** =================================================================
*   LinkedListIm Class
*   Implements linked list functions
*   ===============================================================*/

public class LinkedListIm<T> {

    /** ----------------------------------------------------------------
    *   Start global variables
    *   ---------------------------------------------------------------*/
    private Node<T> head;
    private Node<T> tail;
    private int size = 0;

    /** ----------------------------------------------------------------
    *   Start Methods
    *   ---------------------------------------------------------------*/

    /** ----------------------------------------------------------------
    *   addAfter - Adds an element at the end of the list or specific index.
    *   @param after
    *   @param element
    *   ---------------------------------------------------------------*/
    public void addAfter(T after, T element){

        // global variables
        Node<T> nd = new Node<T>();
        Node<T> tmp = head;
        Node<T> refNode = null;
        this.size++;

        // determine which action to perform based on param
        if (after != null) {

            // display message
            System.out.println("Adding: '" + element + "' after element '" + after + "'.");

            // traverse all elements until given element is found
            while (true){
                if (tmp == null){
                    break;
                }
                if(tmp.compareTo(after) == 0){
                    //found the target node, add after this node
                    refNode = tmp;
                    break;
                }
                tmp = tmp.getNextRef();
            }

            if (refNode != null){
                // set value
                nd.setValue(element);
                // set referance
                nd.setNextRef(tmp.getNextRef());

                if (tmp == tail) {
                    tail = nd;
                }
                tmp.setNextRef(nd);
            }
            else {
                System.out.println("Error: Cannot find element at specific index. Adding to front of list.");
            }
        }
        else {
            // display message
            System.out.println("Adding: '" + element);
            // set value
            nd.setValue(element);

            // check if the list is empty
            if (head == null) {
               // since there is only one element, both head and tail points to the same object.
               head = nd;
               tail = nd;
            }
            else {
               // set current tail next link to new node
               tail.setNextRef(nd);
               // set tail as newly created node
               tail = nd;
            }
        }
    }

    /** ----------------------------------------------------------------
    *   deleteAfter - Deletes an element after specific.
    *   @param after
    *   ---------------------------------------------------------------*/
    public void deleteAfter(T after){

        Node<T> tmp = head;
        Node<T> refNode = null;

        while(true){
            if(tmp == null){
                break;
            }
            if(tmp.compareTo(after) == 0){
                //found the target node, add after this node
                refNode = tmp;
                break;
            }
            tmp = tmp.getNextRef();
        }
        if(refNode != null){
            tmp = refNode.getNextRef();
            refNode.setNextRef(tmp.getNextRef());
            if(refNode.getNextRef() == null){
                tail = refNode;
            }
            System.out.println("Success: Deleted: " + tmp.getValue());
            this.size--;
        }
        else {
            System.out.println("Error: Unable to find the given element.");
        }
    }

    /** ----------------------------------------------------------------
    *   get - get at index
    *   @param index
    *   ---------------------------------------------------------------*/
    public void get(T index){

      Node<T> tmp = head;
      Node<T> refNode = null;

          // traverse all elements until given element is found
          while (true){
              if (tmp == null){
                  break;
              }
              if(tmp.compareTo(index) == 0){
                  //found the target node, add after this node
                  refNode = tmp;
                  System.out.println("\nSuccess: Found item '" + refNode.getValue() + "'.");
              }
              tmp = tmp.getNextRef();
          }
          if (refNode == null) {
              System.out.println("\nError: could not find item at index '" + index + "'.");
          }
    }

    /** ----------------------------------------------------------------
    *   traverse - Sequential sort and print all nodes in the list
    *   @param boolean
    *   ---------------------------------------------------------------*/
    public void traverse(boolean displayEachValue){

        System.out.println("\nStatus: Processing; Traversing all nodes... \n");
        long startTime = System.nanoTime();

        Node<T> tmp = head;
        while(true){
            if(tmp == null){
                break;
            }
            if (displayEachValue == true) {
                System.out.println(tmp.getValue());
            }
            tmp = tmp.getNextRef();
        }

        long estimatedTime = System.nanoTime() - startTime;
        System.out.println("\nStatus: Completed in " + estimatedTime + "; " + this.size + " elements returned. \n");
    }

}
