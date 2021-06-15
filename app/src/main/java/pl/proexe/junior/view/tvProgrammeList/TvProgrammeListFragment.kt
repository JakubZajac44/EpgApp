package pl.proexe.junior.view.tvProgrammeList

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import pl.proexe.junior.R
import pl.proexe.junior.app.EpgApplication
import pl.proexe.junior.model.data.TvProgramme
import pl.proexe.junior.presenter.tvProgramme.TvProgrammePresenter
import pl.proexe.junior.view.adapter.EpgRecyclerAdapter
import javax.inject.Inject

class TvProgrammeListFragment : Fragment(), TvProgrammeListView {


    @Inject
    lateinit var presenter: TvProgrammePresenter

    private lateinit var recyclerView: RecyclerView
    private lateinit var layoutManager: LinearLayoutManager

    var programmeList = mutableListOf<TvProgramme>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.tv_programme_list_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        (activity?.application as EpgApplication).component?.inject(this)
        recyclerView = view.findViewById(R.id.tvProgrammeRecyclerView)
        layoutManager = LinearLayoutManager(activity)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = EpgRecyclerAdapter(programmeList)

        presenter.onViewCreated(this)
    }

    override fun showEpgList(programmes: List<TvProgramme>) {
        programmeList.clear()
        programmeList.addAll(programmes)
        recyclerView.adapter?.notifyDataSetChanged()
    }


}