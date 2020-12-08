package D1;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JPanel;
import D2.trangchinhban;
import D3.douong;
import D4.thongke;
import D6.hoadon;
public class chuyenmanhinh<listDanhMuc> {
	private JPanel panelRoot;
	private String kindSelected = "";
	private List<danhmuc> listDanhMuc;	
	
	public chuyenmanhinh(JPanel panelRoot) {
		this.panelRoot = panelRoot;
	}
	
	public void setView(JPanel panelItem, JLabel lblItem) {
		kindSelected = "trangchinh";
//		khởi đầu khi mở
		panelItem.setBackground(new Color(192,192,192));
	    panelItem.setBackground(new Color(192,192,192));
	    trangchinhban node = new trangchinhban();
	    panelRoot.removeAll();
	    panelRoot.setLayout(new BorderLayout());
	    panelRoot.add(node);
	    panelRoot.validate();
	    panelRoot.repaint();
	}
	
	public void setEvent(List<danhmuc> listDanhMuc) {
	     this.listDanhMuc = listDanhMuc;
	     for (danhmuc item : listDanhMuc) {
	           item.getLbl().addMouseListener((MouseListener) new LabelEvent(item.getKind(), item.getPanel(), item.getLbl()));
	     }
	}
	class LabelEvent implements MouseListener {

		  private JPanel node;
	      private String kind;
	      private JPanel panelItem;
	      private JLabel lblItem;    

	      public LabelEvent(String kind, JPanel PanelItem, JLabel LblItem) {
	           this.kind = kind;
	           this.panelItem = PanelItem;
	           this.lblItem = LblItem;
	      }

	      @Override
	      public void mouseClicked(MouseEvent e) {
	            switch (kind) {
	                case "trangchinh":
	                    node = new trangchinhban();
	                    break;
	                case "douong":
	                	node = new douong();
	                	break;
	                case "thongke":
	                	node = new thongke();
	                	break;
	                case "hoadon":
	                	node = new hoadon();
	                	break;
	                default:
	                    break;
	           }
	           panelRoot.removeAll();
	           panelRoot.setLayout(new BorderLayout());
	           panelRoot.add(node);
	           panelRoot.validate();
	           panelRoot.repaint();
	           setChangeBackgroud(kind);
	           
	      }

	      @Override
//	      chuột nhấn
	      public void mousePressed(MouseEvent e) {
	           kindSelected = kind;
	           panelItem.setBackground(new Color(255,153,0));
	           lblItem.setBackground(new Color(255,153,0));
	      }

	      @Override
	      public void mouseReleased(MouseEvent e) {

	      }

	      @Override
//	      chuột vào
	      public void mouseEntered(MouseEvent e) {
	          panelItem.setBackground(new Color(192,192,192));
	          lblItem.setBackground(new Color(192,192,192));
	      }

	      @Override
//	      chuột ra
	      public void mouseExited(MouseEvent e) {
	          if (!kindSelected.equalsIgnoreCase(kind)) {
	                panelItem.setBackground(new Color(255,153,0));
	                lblItem.setBackground(new Color(255,153,0));
	          }
	      }

	      public void setChangeBackgroud(String kind) {
	  		for(danhmuc item : listDanhMuc) {
//  				chọn mục
	  			if(item.getKind().equalsIgnoreCase(kind)) {
	  				item.getPanel().setBackground(new Color(255,153,0));
	  				item.getLbl().setBackground(new Color(255,153,0));
//	  				nhấn đổi hết
	  			}else {
	  				item.getPanel().setBackground(new Color(255,153,0));
	  				item.getLbl().setBackground(new Color(255,153,0));
	  			}
	  		}
	  	}
	      
	}
}