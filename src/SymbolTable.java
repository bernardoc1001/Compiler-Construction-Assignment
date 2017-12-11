import java.util.*;

// Class for the symbol table. Is a map of maps of the different scopes,
// with STC entries in the inner scope map


//try map of strings and inner maps. String == scope name. Inner maps == variables
//track current scope, previous scope


public class SymbolTable {
    public static final String GLOBAL_SCOPE = "global";
    private String currentScopeName; //Scopes are either "global", "main", or named after a function name (e.g "foobar")
    private ArrayDeque<String> previousScopeNameStack = new ArrayDeque<>(); //Keep track of previous scope on a stack
                                                                        // So if func2 is called inside func1, after func2 is done scope can be returned to func1
    private LinkedHashMap<String, Hashtable<String, STC>> scopeMap; //String = scope name. Inner map = stc entries with their name as the String

    // Constructors
    SymbolTable(String name){
        setCurrentScopeName(name);
        setScopeMap(new LinkedHashMap<String, Hashtable<String, STC>>());
        getScopeMap().put(name, new Hashtable<String, STC>()); //Scope starts off empty
    }

    SymbolTable(String name, LinkedHashMap<String, Hashtable<String, STC>> scopeMap){
        setCurrentScopeName(name);
        setScopeMap(scopeMap);
    }

    // Getter and Setters
    public String getCurrentScopeName(){
        return this.currentScopeName;
    }

    //This setter will be called when changing scopes in the CcalParser
    public void setCurrentScopeName(String currentScopeName) {
        if(getCurrentScopeName() != null){
            pushPreviousScopeNameStack(getCurrentScopeName());
        }
        this.currentScopeName = currentScopeName;
    }

    public void setCurrentScopeNameToPrevious(){
        setCurrentScopeName(popPreviousScopeNameStack());
    }

    // Push a string (usually CurrentScopName) onto the previousScopeName stack
    private void pushPreviousScopeNameStack(String name){
        previousScopeNameStack.push(name);
    }

    private String popPreviousScopeNameStack(){
        return previousScopeNameStack.pop();
    }

    public LinkedHashMap<String, Hashtable<String, STC>> getScopeMap(){
        return this.scopeMap;
    }

    private void setScopeMap(LinkedHashMap<String, Hashtable<String, STC>> scopeMap) {
        this.scopeMap = scopeMap;
    }


    //helper function to get the inner map of a single scope
    private Hashtable<String, STC> getMapOfSingleScope(String scopeName){
        return getScopeMap().get(scopeName);
    }

    //method to add stc variable to current scope
    public void addToScope(String stcName, STC stc){
        addToScope(getCurrentScopeName(), stcName, stc);
    }

    // method to add stc variable to a particular scope
    public void addToScope(String scopeName, String stcName, STC stc){
        Hashtable<String, STC> mapOfSingleScope = getMapOfSingleScope(scopeName);
        if(mapOfSingleScope == null){
            getScopeMap().put(scopeName, new Hashtable<String, STC>()); //make inner map for that scope //todo use setter???
            mapOfSingleScope = getMapOfSingleScope(scopeName);
        }
        mapOfSingleScope.put(stcName, stc);
    }

    // method to get a value from the current scope
    public STC getStcFromScope(String stcName){
        return getStcFromScope(getCurrentScopeName(), stcName);
    }

    // method to get a value from a particular scope
    public STC getStcFromScope(String scopeName, String stcName){
        Hashtable<String, STC> mapOfSingleScope = getMapOfSingleScope(scopeName);
        if(mapOfSingleScope.get(stcName) == null && !scopeName.equals(SymbolTable.GLOBAL_SCOPE)){
            //value not in current scope, try retrieving from global scope
            return getStcFromScope(SymbolTable.GLOBAL_SCOPE, stcName);
        }
        //else return the result (note result may == null)
        return mapOfSingleScope.get(stcName);
    }

    public void printSymbolTable(){
        System.out.println("##### Start Printing out Symbol Table #####");

        //for each scope
        for(Map.Entry<String, Hashtable<String, STC>> scope : getScopeMap().entrySet()){
            //for each variable in scope
            System.out.println("+++++ Start of Scope " + scope.getKey() + " +++++");

            String temp;
            STC temp2;
            Enumeration t = scope.getValue().keys();

            //Print out the symbols in the scope
            while (t.hasMoreElements()) {

                temp = (String) t.nextElement();
                temp2 = (STC) scope.getValue().get(temp);

                System.out.println(" Symbol: " + temp);
                if (temp2.type != null) {
                    System.out.println("  >> type = " + temp2.type);
                }
                if (temp2.value != null) {
                    System.out.println("  >> value = " + temp2.value);
                }
            }

            System.out.println("+++++ End of Scope " + scope.getKey() + " +++++");
        }


        System.out.println("##### End of Printing out Symbol Table #####");
    }

    // write method to check if variable is in current scope

    // write method to see if variable is in global scope



}
