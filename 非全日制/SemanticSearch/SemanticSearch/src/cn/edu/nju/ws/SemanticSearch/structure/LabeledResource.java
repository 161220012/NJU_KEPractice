package cn.edu.nju.ws.SemanticSearch.structure;

// ��ʾ�������б�ǩ��ʵ��
public class LabeledResource {
    public LabeledResource(String iri, String label) {
        this.iri = iri;
        this.label = label;
    }

    public String iri;
    public String label;
}
