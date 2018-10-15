/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reminder;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 *
 * @author jince michael
 */
@Entity
@Table(name = "reminders_table", catalog = "reminder", schema = "")
@NamedQueries({
    @NamedQuery(name = "RemindersTable.findAll", query = "SELECT r FROM RemindersTable r"),
    @NamedQuery(name = "RemindersTable.findByName", query = "SELECT r FROM RemindersTable r WHERE r.remindersTablePK.name = :name"),
    @NamedQuery(name = "RemindersTable.findByNotes", query = "SELECT r FROM RemindersTable r WHERE r.notes = :notes"),
    @NamedQuery(name = "RemindersTable.findByDate", query = "SELECT r FROM RemindersTable r WHERE r.remindersTablePK.date = :date"),
    @NamedQuery(name = "RemindersTable.findByTime", query = "SELECT r FROM RemindersTable r WHERE r.time = :time"),
    @NamedQuery(name = "RemindersTable.findByPriority", query = "SELECT r FROM RemindersTable r WHERE r.priority = :priority"),
    @NamedQuery(name = "RemindersTable.findByCompleted", query = "SELECT r FROM RemindersTable r WHERE r.completed = :completed")})
public class RemindersTable implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected RemindersTablePK remindersTablePK;
    @Basic(optional = false)
    @Column(name = "notes")
    private String notes;
    @Basic(optional = false)
    @Column(name = "time")
    @Temporal(TemporalType.TIME)
    private Date time;
    @Basic(optional = false)
    @Column(name = "priority")
    private boolean priority;
    @Basic(optional = false)
    @Column(name = "completed")
    private boolean completed;

    public RemindersTable() {
    }

    public RemindersTable(RemindersTablePK remindersTablePK) {
        this.remindersTablePK = remindersTablePK;
    }

    public RemindersTable(RemindersTablePK remindersTablePK, String notes, Date time, boolean priority, boolean completed) {
        this.remindersTablePK = remindersTablePK;
        this.notes = notes;
        this.time = time;
        this.priority = priority;
        this.completed = completed;
    }

    public RemindersTable(String name, Date date) {
        this.remindersTablePK = new RemindersTablePK(name, date);
    }

    public RemindersTablePK getRemindersTablePK() {
        return remindersTablePK;
    }

    public void setRemindersTablePK(RemindersTablePK remindersTablePK) {
        this.remindersTablePK = remindersTablePK;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        String oldNotes = this.notes;
        this.notes = notes;
        changeSupport.firePropertyChange("notes", oldNotes, notes);
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        Date oldTime = this.time;
        this.time = time;
        changeSupport.firePropertyChange("time", oldTime, time);
    }

    public boolean getPriority() {
        return priority;
    }

    public void setPriority(boolean priority) {
        boolean oldPriority = this.priority;
        this.priority = priority;
        changeSupport.firePropertyChange("priority", oldPriority, priority);
    }

    public boolean getCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        boolean oldCompleted = this.completed;
        this.completed = completed;
        changeSupport.firePropertyChange("completed", oldCompleted, completed);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (remindersTablePK != null ? remindersTablePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RemindersTable)) {
            return false;
        }
        RemindersTable other = (RemindersTable) object;
        if ((this.remindersTablePK == null && other.remindersTablePK != null) || (this.remindersTablePK != null && !this.remindersTablePK.equals(other.remindersTablePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "reminder.RemindersTable[ remindersTablePK=" + remindersTablePK + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
