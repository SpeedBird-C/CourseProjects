public class Bear extends Animal {

	public Bear(String status) {
		super(status);
	}

	@Override
	public void makeMove(SiteGrid sg) {
		try {
			if (status == "ALIVE") {
				if (this.getSite().getType() == SiteType.WINTERING) {
					if (Math.random() <= 0.3)
						this.die();
					else
						super.makeMove(sg);
				} else
					super.makeMove(sg);
			}
		} catch (NullPointerException e) {
			super.makeMove(sg);
		}
	}
}
