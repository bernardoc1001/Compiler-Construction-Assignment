import java.util.*;

// Class for the symbol table. Is a map of maps of the different scopes,
// with STC entries in the inner scope map


//try map of strings and inner maps. String == scope name. Inner maps == variables
//track current scope, previous scope


public class SymbolTable {
    public static final String GLOBAL_SCOPE = "global";
    private String scopeName;
    private LinkedHashMap<String, Hashtable<String, STC>> scopeMap; //String = scope name. Inner map = stc entries with their name as the String

    // Constructors
    SymbolTable(String name){
        setScopeName(name);
        setScopeMap(new LinkedHashMap<String, Hashtable<String, STC>>());
        getScopeMap().put(name, new Hashtable<String, STC>()); //Scope starts off empty
    }

    SymbolTable(String name, LinkedHashMap<String, Hashtable<String, STC>> scopeMap){
        setScopeName(name);
        setScopeMap(scopeMap);
    }

    // Getter and Setters
    public String getScopeName(){
        return this.scopeName;
    }

    private void setScopeName(String scopeName) {
        this.scopeName = scopeName;
    }


    public LinkedHashMap<String, Hashtable<String, STC>> getScopeMap(){
        return this.scopeMap;
    }

    private void setScopeMap(LinkedHashMap<String, Hashtable<String, STC>> scopeMap) {
        this.scopeMap = scopeMap;
    }

    // method to add stc variable to a particular scope
    public void addToScope(String scopeName, String stcName, STC stc){
        LinkedHashMap<String, Hashtable<String, STC>> mapOfAllScopes = getScopeMap();
        Hashtable<String, STC> mapOfSingleScope = mapOfAllScopes.get(scopeName);
        mapOfSingleScope.put(stcName, stc);
    }

    // method to get a value from a particular scope
    public STC getStcFromScope(String scopeName, String stcName){
        LinkedHashMap<String, Hashtable<String, STC>> mapOfAllScopes = getScopeMap();
        Hashtable<String, STC> mapOfSingleScope = mapOfAllScopes.get(scopeName);
        return mapOfSingleScope.get(stcName);
    }

    //todo finish print
    public void printScope(){
        System.out.println("***** Start of Scope: " + getScopeName() + " *****" );
//        for(){
//
//        }
        System.out.println("***** End of Scope: " + getScopeName() + " *****");
    }

    // write method to check if variable is in current scope

    // write method to see if variable is in global scope



}
