package service.commonService.util;

import model.Resource;

import java.util.ArrayList;
import java.util.List;

public class SysResourceTreeNode extends Resource {

    private List<SysResourceTreeNode> children;

    public void addChild(SysResourceTreeNode node) {
        if (this.children == null) {
            children = new ArrayList<>();
        }
        children.add(node);
    }

    public void setChildren(List<SysResourceTreeNode> children) {
        this.children = children;
    }

    public List<SysResourceTreeNode> getChildren() {
        return children;
    }
}
