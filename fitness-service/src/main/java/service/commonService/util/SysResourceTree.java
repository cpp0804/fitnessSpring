package service.commonService.util;

import common.util.BeanUtils;
import model.Resource;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

public class SysResourceTree implements Serializable {

    List<Resource> resources;

    private Map<Integer, SysResourceTreeNode> tree = new HashMap<>();

    public SysResourceTree(List<Resource> resources) {
        this.resources = resources;
        buildResourceTree();
    }

    private synchronized void buildResourceTree() {
        for (Resource resource : resources) {
            SysResourceTreeNode node = new SysResourceTreeNode();
            try {
                BeanUtils.copyProperties(node, resource);
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            if (tree.containsKey(resource.getParentId())) {
                SysResourceTreeNode parentNode = tree.get(resource.getParentId());
                parentNode.addChild(node);
            }
            tree.put(resource.getResourceId(), node);
        }
    }

    public synchronized JSONObject buildMenuResourceTree(List<Integer> resourceIds) {
        List<SysResourceTreeNode> menuNodes = new ArrayList<>();
        for (Integer resourceId : resourceIds) {
            SysResourceTreeNode node = this.getNode(resourceId);

            menuNodes.add(node);
            this.setAncenodes(this.getNode(resourceId), menuNodes);
        }

        removeDuplicateWithOrder(menuNodes);

        JSONObject menuJSONObject = new JSONObject();
        JSONArray menus = new JSONArray();

        List<SysResourceTreeNode> childrenNodes = null;

        for (SysResourceTreeNode resourceTreeNode : menuNodes) {
            //在（10-100),表示一级菜单
            if (Integer.parseInt(resourceTreeNode.getCode()) < 100) {
                menus.add(buildFirstLevelMenuNode(menuNodes, resourceTreeNode));
            }
        }
        menuJSONObject.put("data", menus);
        return menuJSONObject;
    }

    // 递归依次获取该菜单的上级祖先菜单节点
    private synchronized void setAncenodes(SysResourceTreeNode node, List<SysResourceTreeNode> menuNodes) {
        if (tree.containsKey(node.getParentId())) {
            SysResourceTreeNode parentNode = tree.get(node.getParentId());
            if (!menuNodes.contains(parentNode)) {
                menuNodes.add(parentNode);
            }
            this.setAncenodes(parentNode, menuNodes);
        }
    }

    private void removeDuplicateWithOrder(List<SysResourceTreeNode> list) {
        Set<SysResourceTreeNode> set = new HashSet<>();
        List<SysResourceTreeNode> newList = new ArrayList<>();
        for (Iterator iterator = list.iterator(); iterator.hasNext(); ) {
            Object element = iterator.next();
            if (set.add((SysResourceTreeNode) element)) {
                newList.add((SysResourceTreeNode) element);
            }
        }
        list.clear();
        list.addAll(newList);
    }

    private JSONObject buildFirstLevelMenuNode(List<SysResourceTreeNode> menuNodes, SysResourceTreeNode firstLevelNode) {
        JSONObject firstLevelMenuNode = new JSONObject();
        JSONArray secondLevelMenus = new JSONArray();

        //从当前父节点集合中，获取一级菜单的二级孩子节点
        List<SysResourceTreeNode> childrenNodes = getChildren(menuNodes, firstLevelNode);

        for (SysResourceTreeNode secondLevelNode : childrenNodes) {
            //priority 在（1000-10000),表示二级菜单
            if (Integer.parseInt(secondLevelNode.getCode()) < 1000 && Integer.parseInt(secondLevelNode.getCode()) > 100) {
                secondLevelMenus.add(buildSecondLevelMenuNode(secondLevelNode));
            }
        }
        String url = firstLevelNode.getUrl();
        firstLevelMenuNode.put("id", firstLevelNode.getResourceId());
        firstLevelMenuNode.put("url", url);
        firstLevelMenuNode.put("content", convertUrlToContent(url));
        firstLevelMenuNode.put("icon", firstLevelNode.getIcon());
        firstLevelMenuNode.put("menus", secondLevelMenus);

        return firstLevelMenuNode;
    }

    private JSONObject buildSecondLevelMenuNode(SysResourceTreeNode secondLevelNode) {
        JSONObject secondLevelmenuNode = new JSONObject();
        String url = secondLevelNode.getUrl();
        secondLevelmenuNode.put("id", secondLevelNode.getResourceId());
        secondLevelmenuNode.put("icon", secondLevelNode.getIcon());
        secondLevelmenuNode.put("url", url);
        secondLevelmenuNode.put("content", convertUrlToContent(url));
        return secondLevelmenuNode;

    }

    private String convertUrlToContent(String url) {
        if (StringUtils.isEmpty(url)) {
            return "";
        }
        String names[] = url.split("/");
        return names[names.length - 1];
    }

    private List<SysResourceTreeNode> getChildren(List<SysResourceTreeNode> anceNodes, SysResourceTreeNode currentNode) {
        List<SysResourceTreeNode> chidlrenNodes = new ArrayList<>();
        for (SysResourceTreeNode resourceTreeNode : anceNodes) {
            if (currentNode.getResourceId().equals(resourceTreeNode.getParentId())) {
                chidlrenNodes.add(resourceTreeNode);
            }
        }
        return chidlrenNodes;
    }

    public synchronized SysResourceTreeNode getNode(Integer key) {
        return tree.get(key);
    }
}
