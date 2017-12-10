import java.util.*;

public class TypeCheckVisitor implements CCALParserVisitor {

    private static Object getDataType(SimpleNode node, Object data){
        Hashtable ST = (Hashtable) data;
        STC hashTableEntry;

        hashTableEntry = (STC)ST.get(node.value);
        if(Objects.equals(hashTableEntry.type, "integer")){
            System.out.println("Returning TypeInteger");
            return DataType.TypeInteger;
        }
        else if(Objects.equals(hashTableEntry.type, "boolean")){
            System.out.println("Returning TypeBoolean");
            return DataType.TypeBoolean;
        }
        else if(Objects.equals(hashTableEntry.type, "void")){
            System.out.println("Returning TypeVoid");
            return DataType.TypeVoid;
        }
        else{
            System.out.println("Returning TypeUnknown");
            return DataType.TypeUnknown;
        }
    }

    @Override
    public Object visit(SimpleNode node, Object data){
        throw new RuntimeException("Visit SimpleNode");
    }

    @Override
    public Object visit(ASTProgram node, Object data){
        //System.out.println("Start of program visitor");
        node.childrenAccept(this, data);
        System.out.println("END OF PROGRAM");
        return (DataType.Program);
    }

    //Write rest of the methods in alphabetical order
    @Override
    public Object visit(ASTArgList node, Object data){
        //System.out.println("Start of Arglist visitor");
        System.out.println(node.value);
        node.childrenAccept(this, data);
        return (data);
    }

    @Override
    public Object visit(ASTBinaryArithOp node, Object data){
        //System.out.println("Start of BinaryArithOp visitor");
        System.out.println(node.value);
        node.childrenAccept(this, data);
        return (data);
    }

    @Override
    public Object visit(ASTCompOp node, Object data){
        //System.out.println("Start of CompOp visitor");
        System.out.println(node.value);
        node.childrenAccept(this, data);
        return (data);
    }

    @Override
    public Object visit(ASTCondition node, Object data){
        //System.out.println("Start of Condition visitor");
        System.out.println(node.value);
        node.childrenAccept(this, data);
        return (data);
    }

    @Override
    public Object visit(ASTConditionAlpha node, Object data){
        //System.out.println("Start of ConditionAlpha visitor");
        System.out.println(node.value);
        node.childrenAccept(this, data);
        return (data);
    }

    @Override
    public Object visit(ASTConditionBeta node, Object data){
        //System.out.println("Start of ConditionBeta visitor");
        System.out.println(node.value);
        node.childrenAccept(this, data);
        return (data);
    }

    @Override
    public Object visit(ASTConditionPrime node, Object data){
        //System.out.println("Start of ConditionPrime visitor");
        System.out.println(node.value);
        node.childrenAccept(this, data);
        return (data);
    }

    @Override
    public Object visit(ASTConstDecl node, Object data){
        //System.out.println("Start of ConstDecl visitor");
        System.out.println(node.value);
        node.childrenAccept(this, data);
        return (data);
    }

    @Override
    public Object visit(ASTDecl node, Object data){
        //System.out.println("Start of Decl visitor");
        System.out.println(node.value);
        node.childrenAccept(this, data);
        return (data);
    }

    @Override
    public Object visit(ASTDeclList node, Object data){
        //System.out.println("Start of DeclList visitor");
        System.out.println(node.value);
        node.childrenAccept(this, data);
        return (data);
    }

    @Override
    public Object visit(ASTExpression node, Object data){
        //System.out.println("Start of Expression visitor");
        System.out.println(node.value);
        node.childrenAccept(this, data);
        return (data);
    }

    @Override
    public Object visit(ASTExpressionAlpha node, Object data){
        //System.out.println("Start of ExpressionAlpha visitor");
        System.out.println(node.value);
        node.childrenAccept(this, data);
        return (data);
    }

    @Override
    public Object visit(ASTExpressionBeta node, Object data){
        //System.out.println("Start of ExpressionBeta visitor");
        System.out.println(node.value);
        node.childrenAccept(this, data);
        return (data);
    }

    @Override
    public Object visit(ASTFragment node, Object data){
        //System.out.println("Start of Fragment visitor");
        System.out.println(node.value);
        node.childrenAccept(this, data);
        return (data);
    }

    @Override
    public Object visit(ASTFragmentDelta node, Object data){
        //System.out.println("Start of FragmentDelta visitor");
        System.out.println(node.value);
        node.childrenAccept(this, data);
        return (data);
    }

    @Override
    public Object visit(ASTFragmentPrime node, Object data){
        //System.out.println("Start of FragmentPrime visitor");
        System.out.println(node.value);
        node.childrenAccept(this, data);
        return (data);
    }

    @Override
    public Object visit(ASTFunction node, Object data){
        //System.out.println("Start of Function visitor");
        //System.out.println(node.value);
        //node.childrenAccept(this, data);
        //return (data);

        System.out.println("At function, getting type");

        return getDataType(node, data);
    }

    @Override
    public Object visit(ASTFunctionList node, Object data){
        //System.out.println("Start of FunctionList visitor");
        System.out.println(node.value);
        node.childrenAccept(this, data);
        return (data);
    }

    @Override
    public Object visit(ASTID node, Object data){
        //System.out.println("Start of ID visitor");
        //System.out.println(node.value);
        //node.childrenAccept(this, data);
        //return (data);
        System.out.println("At ID, getting type");

        return getDataType(node, data);
    }

    @Override
    public Object visit(ASTMain node, Object data){
        //System.out.println("Start of Main visitor");
        System.out.println(node.value);
        node.childrenAccept(this, data);
        return (data);
    }

    @Override
    public Object visit(ASTNempArgList node, Object data){
        //System.out.println("Start of NempArgList visitor");
        System.out.println(node.value);
        node.childrenAccept(this, data);
        return (data);
    }

    @Override
    public Object visit(ASTNempArgListPrime node, Object data){
        //System.out.println("Start of NempArgListPrime visitor");
        System.out.println(node.value);
        node.childrenAccept(this, data);
        return (data);
    }

    @Override
    public Object visit(ASTNempParameterList node, Object data){
        //System.out.println("Start of NempParameterList visitor");
        System.out.println(node.value);
        node.childrenAccept(this, data);
        return (data);
    }

    @Override
    public Object visit(ASTNempParameterListPrime node, Object data){
        //System.out.println("Start of NempParameterListPrime visitor");
        System.out.println(node.value);
        node.childrenAccept(this, data);
        return (data);
    }

    @Override
    public Object visit(ASTNum node, Object data){
        //System.out.println("Start of Num visitor");
        //System.out.println(node.value);
        //node.childrenAccept(this, data);
        return DataType.TypeInteger;
    }

    @Override
    public Object visit(ASTParameterList node, Object data){
        //System.out.println("Start of ParameterList visitor");
        System.out.println(node.value);
        node.childrenAccept(this, data);
        return (data);
    }

    @Override
    public Object visit(ASTStatement node, Object data){
        //System.out.println("Start of Statement visitor");
        System.out.println(node.value);
        node.childrenAccept(this, data);
        return (data);
    }

    @Override
    public Object visit(ASTStatementBlock node, Object data){
        //System.out.println("Start of StatementBlock visitor");
        System.out.println(node.value);
        node.childrenAccept(this, data);
        return (data);
    }

    @Override
    public Object visit(ASTStatementPrime node, Object data){
        //System.out.println("Start of StatementPrime visitor");
        System.out.println(node.value);
        node.childrenAccept(this, data);
        return (data);
    }

    @Override
    public Object visit(ASTType node, Object data){
        //System.out.println("Start of Type visitor");
        System.out.println(node.value);
        node.childrenAccept(this, data);
        return (data);
    }

    @Override
    public Object visit(ASTVarDecl node, Object data){
        //System.out.println("Start of VarDecl visitor");
        System.out.println(node.value);
        node.childrenAccept(this, data);
        return (data);
    }
}
