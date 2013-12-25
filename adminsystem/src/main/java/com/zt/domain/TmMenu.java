package com.zt.domain;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;


@Entity
@Table(name = "TM_MENU", schema = "dbo", catalog = "AdminSystem")
@SQLDelete(sql="UPDATE TM_MENU SET ISDELETE = '1' WHERE SETTINGS_ID = ?")
@Where(clause="ISDELETE <> '1'")
public class TmMenu extends BaseEntity implements java.io.Serializable {

	// Fields
		@GenericGenerator(name = "generator", strategy = "uuid.hex")
		@Id
		@GeneratedValue(generator = "generator")
		@Column(name = "MENU_ID", unique = true, nullable = false)
		private String menuid;
		@Column(name = "MENUNAME")
		private String menuname;
		@Column(name = "ICON")
		private String icon;
		@Column(name = "URL")
		private String url;
		@Column(name = "CHILD")
		private Boolean child;
		@Column(name = "MENUS")
		private Integer menus;
		@Column(name = "CREATOR", length = 24)
		private String creator;
		@Column(name = "CREATETIME", length = 23)
		private Timestamp createtime;
		@Column(name = "VERSION")
		private Integer version;
		@Column(name = "ISDELETE")
		private Boolean isdelete;
		
		public TmMenu(){
			
		}
		
		
		public String getMenuid() {
			return menuid;
		}
		public void setMenuid(String menuid) {
			this.menuid = menuid;
		}
		public String getMenuname() {
			return menuname;
		}
		public void setMenuname(String menuname) {
			this.menuname = menuname;
		}
		public String getIcon() {
			return icon;
		}
		public void setIcon(String icon) {
			this.icon = icon;
		}
		public String getUrl() {
			return url;
		}
		public void setUrl(String url) {
			this.url = url;
		}
		public Boolean getChild() {
			return child;
		}
		public void setChild(Boolean child) {
			this.child = child;
		}
		public Integer getMenus() {
			return menus;
		}
		public void setMenus(Integer menus) {
			this.menus = menus;
		}
		public String getCreator() {
			return creator;
		}
		public void setCreator(String creator) {
			this.creator = creator;
		}
		public Timestamp getCreatetime() {
			return createtime;
		}
		public void setCreatetime(Timestamp createtime) {
			this.createtime = createtime;
		}
		public Integer getVersion() {
			return version;
		}
		public void setVersion(Integer version) {
			this.version = version;
		}
		public Boolean getIsdelete() {
			return isdelete;
		}
		public void setIsdelete(Boolean isdelete) {
			this.isdelete = isdelete;
		}

	
}
