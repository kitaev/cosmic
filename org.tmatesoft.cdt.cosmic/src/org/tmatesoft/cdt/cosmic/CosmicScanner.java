package org.tmatesoft.cdt.cosmic;

import java.util.Map;

import org.eclipse.cdt.core.dom.ast.IMacroBinding;
import org.eclipse.cdt.core.parser.EndOfFileException;
import org.eclipse.cdt.core.parser.IScanner;
import org.eclipse.cdt.core.parser.IToken;
import org.eclipse.cdt.core.parser.OffsetLimitReachedException;
import org.eclipse.cdt.internal.core.parser.scanner.ILocationResolver;

@SuppressWarnings("restriction")
public class CosmicScanner implements IScanner {
    
    private IScanner delegate;

    public CosmicScanner(IScanner delegate) {
        this.delegate = delegate;
    }

    @Override
    public Map<String, IMacroBinding> getMacroDefinitions() {
        return delegate.getMacroDefinitions();
    }

    @Override
    public IToken nextToken() throws EndOfFileException {
        while(true) {
            final IToken t = delegate.nextToken();
            if (t != null && t.getType() == IToken.tIDENTIFIER) {
                final String image = t.getImage();
                if (image != null && image.length() > 0 && image.charAt(0) == '@') {
                    continue;
                }
            }
            return t;
        }
    }

    @Override
    public boolean isOnTopContext() {
        return delegate.isOnTopContext();
    }

    @Override
    public void cancel() {
        delegate.cancel();
    }

    @Override
    public ILocationResolver getLocationResolver() {
        return delegate.getLocationResolver();
    }

    @Override
    public void setContentAssistMode(int offset) {
        delegate.setContentAssistMode(offset);
    }

    @Override
    public void setSplitShiftROperator(boolean val) {
        delegate.setSplitShiftROperator(val);
    }

    @Override
    public void setComputeImageLocations(boolean val) {
        delegate.setComputeImageLocations(val);
    }

    @Override
    public void setProcessInactiveCode(boolean val) {
        delegate.setProcessInactiveCode(val);
    }

    @Override
    public void skipInactiveCode() throws OffsetLimitReachedException {
        delegate.skipInactiveCode();
    }

    @Override
    public int getCodeBranchNesting() {
        return delegate.getCodeBranchNesting();
    }

    @Override
    @Deprecated
    public void setScanComments(boolean val) {
        delegate.setScanComments(val);
    }

}
