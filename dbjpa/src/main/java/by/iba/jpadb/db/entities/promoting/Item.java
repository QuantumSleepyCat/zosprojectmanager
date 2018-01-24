package by.iba.jpadb.db.entities.promoting;



import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "promote_item")
public class Item implements Serializable{

    @Id
    @GeneratedValue
    private long id;
    @Column
    private String name;
    @OneToMany(mappedBy = "item")
    private List<DataSet> dataSets;
    @ManyToOne
    @JoinColumn(name = "info_id")
    private PageInfoModel pageInfoModel;

    public Item()
    {
        dataSets=new ArrayList<>();
    }

    public PageInfoModel getPageInfoModel() {
        return pageInfoModel;
    }

    public void setPageInfoModel(PageInfoModel pageInfoModel) {
        this.pageInfoModel = pageInfoModel;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDataSet(DataSet dataSet)
    {
        dataSets.add(dataSet);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<DataSet> getDataSets() {
        return dataSets;
    }

    public void setDataSets(List<DataSet> dataSets) {
        this.dataSets = dataSets;
    }

    public int randomHash() {
        int code = (int) (name.length()+(Math.random()*23));
        for(DataSet dataSet : dataSets)
        {
            code+=dataSet.randomHash();
        }
        return code;
    }
}
