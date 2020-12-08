package D1;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class danhmuc {

    private String kind;
    private JPanel panel;
    private JLabel lbl;

    public danhmuc() {
    }

    public danhmuc(String kind, JPanel panel, JLabel lbl) {
        this.kind = kind;
        this.panel = panel;
        this.lbl = lbl;
    }

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public JPanel getPanel() {
		return panel;
	}

	public void setPanel(JPanel panel) {
		this.panel = panel;
	}

	public JLabel getLbl() {
		return lbl;
	}

	public void setLbl(JLabel lbl) {
		this.lbl = lbl;
	}
    
}
