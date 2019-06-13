package cn.edu.nju.ws.SemanticSearch.structure;

import java.util.*;

// ��ʾһ��ʵ��
public class HittingInstance implements Comparable<HittingInstance> {
	// ʵ����IRI
    public String iri;
    // ʵ���ı�ǩ
    public String label;
    // ʵ����������Ϣ
    public Map<String, Set<String>> attributes;
    // ʵ����������Ϣ
    public Set<LabeledResource> types;
    // ʵ���ĵ÷�
    protected Double score;

    public HittingInstance(String iri, String label) {
        this.iri = iri;
        this.label = label;
        attributes = new HashMap<>();
        types = new HashSet<>();
        score = null;
    }

    public void addAttribute(String property, String literal) {
        if (!attributes.containsKey(property)) {
            attributes.put(property, new HashSet<String>());
        }
        attributes.get(property).add(literal);
    }

    public void addType(String type, String label) {
        types.add(new LabeledResource(type, label));
    }

    // ����ʵ���ķ�����������������
    public double computeScore(List<String> keywords) {
        return Math.random();
    }

    public void updateScore(List<String> keyword) {
        this.score = computeScore(keyword);
    }

    @Override
    public int compareTo(HittingInstance o) {
        if (score > o.score) {
            return 1;
        } else if (score.equals(o.score)) {
            return 0;
        } else {
            return -1;
        }
    }
}
