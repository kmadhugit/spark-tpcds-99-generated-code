/* 001 */ public Object generate(Object[] references) {
/* 002 */   return new GeneratedIterator(references);
/* 003 */ }
/* 004 */
/* 005 */ final class GeneratedIterator extends org.apache.spark.sql.execution.BufferedRowIterator {
/* 006 */   private Object[] references;
/* 007 */   private scala.collection.Iterator[] inputs;
/* 008 */   private boolean agg_initAgg;
/* 009 */   private boolean agg_bufIsNull;
/* 010 */   private long agg_bufValue;
/* 011 */   private boolean agg_bufIsNull1;
/* 012 */   private double agg_bufValue1;
/* 013 */   private boolean agg_bufIsNull2;
/* 014 */   private double agg_bufValue2;
/* 015 */   private boolean agg_bufIsNull3;
/* 016 */   private double agg_bufValue3;
/* 017 */   private org.apache.spark.sql.execution.aggregate.HashAggregateExec agg_plan;
/* 018 */   private agg_FastHashMap agg_fastHashMap;
/* 019 */   private org.apache.spark.unsafe.KVIterator agg_fastHashMapIter;
/* 020 */   private org.apache.spark.sql.execution.UnsafeFixedWidthAggregationMap agg_hashMap;
/* 021 */   private org.apache.spark.sql.execution.UnsafeKVExternalSorter agg_sorter;
/* 022 */   private org.apache.spark.unsafe.KVIterator agg_mapIter;
/* 023 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_peakMemory;
/* 024 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_spillSize;
/* 025 */   private scala.collection.Iterator smj_leftInput;
/* 026 */   private scala.collection.Iterator smj_rightInput;
/* 027 */   private InternalRow smj_leftRow;
/* 028 */   private InternalRow smj_rightRow;
/* 029 */   private int smj_value2;
/* 030 */   private java.util.ArrayList smj_matches;
/* 031 */   private int smj_value3;
/* 032 */   private int smj_value4;
/* 033 */   private boolean smj_isNull2;
/* 034 */   private int smj_value5;
/* 035 */   private boolean smj_isNull3;
/* 036 */   private int smj_value6;
/* 037 */   private boolean smj_isNull4;
/* 038 */   private int smj_value7;
/* 039 */   private boolean smj_isNull5;
/* 040 */   private int smj_value8;
/* 041 */   private boolean smj_isNull6;
/* 042 */   private int smj_value9;
/* 043 */   private boolean smj_isNull7;
/* 044 */   private int smj_value10;
/* 045 */   private boolean smj_isNull8;
/* 046 */   private double smj_value11;
/* 047 */   private boolean smj_isNull9;
/* 048 */   private double smj_value12;
/* 049 */   private boolean smj_isNull10;
/* 050 */   private double smj_value13;
/* 051 */   private boolean smj_isNull11;
/* 052 */   private int smj_value14;
/* 053 */   private boolean smj_isNull12;
/* 054 */   private org.apache.spark.sql.execution.metric.SQLMetric smj_numOutputRows;
/* 055 */   private UnsafeRow smj_result;
/* 056 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder smj_holder;
/* 057 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter smj_rowWriter;
/* 058 */   private UnsafeRow project_result;
/* 059 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder;
/* 060 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter;
/* 061 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast;
/* 062 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation;
/* 063 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows;
/* 064 */   private UnsafeRow bhj_result;
/* 065 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder;
/* 066 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter;
/* 067 */   private UnsafeRow project_result1;
/* 068 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder1;
/* 069 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter1;
/* 070 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast1;
/* 071 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation1;
/* 072 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows1;
/* 073 */   private UnsafeRow bhj_result1;
/* 074 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder1;
/* 075 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter1;
/* 076 */   private UnsafeRow project_result2;
/* 077 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder2;
/* 078 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter2;
/* 079 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast2;
/* 080 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation2;
/* 081 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows2;
/* 082 */   private UnsafeRow bhj_result2;
/* 083 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder2;
/* 084 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter2;
/* 085 */   private UnsafeRow project_result3;
/* 086 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder3;
/* 087 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter3;
/* 088 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast3;
/* 089 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation3;
/* 090 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows3;
/* 091 */   private UnsafeRow bhj_result3;
/* 092 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder3;
/* 093 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter3;
/* 094 */   private UnsafeRow project_result4;
/* 095 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder4;
/* 096 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter4;
/* 097 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast4;
/* 098 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation4;
/* 099 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows4;
/* 100 */   private UnsafeRow bhj_result4;
/* 101 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder4;
/* 102 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter4;
/* 103 */   private UnsafeRow project_result5;
/* 104 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder5;
/* 105 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter5;
/* 106 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast5;
/* 107 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation5;
/* 108 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows5;
/* 109 */   private UnsafeRow bhj_result5;
/* 110 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder5;
/* 111 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter5;
/* 112 */   private UnsafeRow project_result6;
/* 113 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder6;
/* 114 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter6;
/* 115 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast6;
/* 116 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation6;
/* 117 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows6;
/* 118 */   private UnsafeRow bhj_result6;
/* 119 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder6;
/* 120 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter6;
/* 121 */   private UnsafeRow project_result7;
/* 122 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder7;
/* 123 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter7;
/* 124 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast7;
/* 125 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation7;
/* 126 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows7;
/* 127 */   private UnsafeRow bhj_result7;
/* 128 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder7;
/* 129 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter7;
/* 130 */   private UnsafeRow project_result8;
/* 131 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder8;
/* 132 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter8;
/* 133 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast8;
/* 134 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation8;
/* 135 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows8;
/* 136 */   private UnsafeRow bhj_result8;
/* 137 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder8;
/* 138 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter8;
/* 139 */   private UnsafeRow project_result9;
/* 140 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder9;
/* 141 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter9;
/* 142 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast9;
/* 143 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation9;
/* 144 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows9;
/* 145 */   private UnsafeRow bhj_result9;
/* 146 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder9;
/* 147 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter9;
/* 148 */   private UnsafeRow project_result10;
/* 149 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder10;
/* 150 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter10;
/* 151 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast10;
/* 152 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation10;
/* 153 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows10;
/* 154 */   private UnsafeRow bhj_result10;
/* 155 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder10;
/* 156 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter10;
/* 157 */   private UnsafeRow project_result11;
/* 158 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder11;
/* 159 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter11;
/* 160 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast11;
/* 161 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation11;
/* 162 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows11;
/* 163 */   private UnsafeRow bhj_result11;
/* 164 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder11;
/* 165 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter11;
/* 166 */   private UnsafeRow project_result12;
/* 167 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder12;
/* 168 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter12;
/* 169 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast12;
/* 170 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation12;
/* 171 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows12;
/* 172 */   private UnsafeRow bhj_result12;
/* 173 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder12;
/* 174 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter12;
/* 175 */   private UnsafeRow project_result13;
/* 176 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder13;
/* 177 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter13;
/* 178 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast13;
/* 179 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation13;
/* 180 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows13;
/* 181 */   private UnsafeRow bhj_result13;
/* 182 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder13;
/* 183 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter13;
/* 184 */   private UnsafeRow project_result14;
/* 185 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder14;
/* 186 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter14;
/* 187 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast14;
/* 188 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation14;
/* 189 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows14;
/* 190 */   private UnsafeRow bhj_result14;
/* 191 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder14;
/* 192 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter14;
/* 193 */   private UnsafeRow project_result15;
/* 194 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder15;
/* 195 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter15;
/* 196 */   private UnsafeRow agg_result15;
/* 197 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder;
/* 198 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter;
/* 199 */   private int agg_value38;
/* 200 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowJoiner agg_unsafeRowJoiner;
/* 201 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_numOutputRows;
/* 202 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_aggTime;
/* 203 */
/* 204 */   public GeneratedIterator(Object[] references) {
/* 205 */     this.references = references;
/* 206 */   }
/* 207 */
/* 208 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 209 */     partitionIndex = index;
/* 210 */     this.inputs = inputs;
/* 211 */     wholestagecodegen_init_0();
/* 212 */     wholestagecodegen_init_1();
/* 213 */     wholestagecodegen_init_2();
/* 214 */     wholestagecodegen_init_3();
/* 215 */     wholestagecodegen_init_4();
/* 216 */     wholestagecodegen_init_5();
/* 217 */     wholestagecodegen_init_6();
/* 218 */     wholestagecodegen_init_7();
/* 219 */     wholestagecodegen_init_8();
/* 220 */     wholestagecodegen_init_9();
/* 221 */     wholestagecodegen_init_10();
/* 222 */     wholestagecodegen_init_11();
/* 223 */     wholestagecodegen_init_12();
/* 224 */     wholestagecodegen_init_13();
/* 225 */
/* 226 */   }
/* 227 */
/* 228 */   private void wholestagecodegen_init_9() {
/* 229 */     this.project_rowWriter10 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder10, 13);
/* 230 */     this.bhj_broadcast10 = (org.apache.spark.broadcast.TorrentBroadcast) references[24];
/* 231 */
/* 232 */     bhj_relation10 = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast10.value()).asReadOnlyCopy();
/* 233 */     incPeakExecutionMemory(bhj_relation10.estimatedSize());
/* 234 */
/* 235 */     this.bhj_numOutputRows10 = (org.apache.spark.sql.execution.metric.SQLMetric) references[25];
/* 236 */     bhj_result10 = new UnsafeRow(18);
/* 237 */     this.bhj_holder10 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result10, 192);
/* 238 */     this.bhj_rowWriter10 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder10, 18);
/* 239 */     project_result11 = new UnsafeRow(16);
/* 240 */     this.project_holder11 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result11, 192);
/* 241 */     this.project_rowWriter11 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder11, 16);
/* 242 */     this.bhj_broadcast11 = (org.apache.spark.broadcast.TorrentBroadcast) references[26];
/* 243 */
/* 244 */   }
/* 245 */
/* 246 */   private void wholestagecodegen_init_0() {
/* 247 */     agg_initAgg = false;
/* 248 */
/* 249 */     this.agg_plan = (org.apache.spark.sql.execution.aggregate.HashAggregateExec) references[0];
/* 250 */     agg_fastHashMap = new agg_FastHashMap(agg_plan.getTaskMemoryManager(), agg_plan.getEmptyAggregationBuffer());
/* 251 */
/* 252 */     this.agg_peakMemory = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 253 */     this.agg_spillSize = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 254 */     smj_leftInput = inputs[0];
/* 255 */     smj_rightInput = inputs[1];
/* 256 */
/* 257 */     smj_rightRow = null;
/* 258 */
/* 259 */     smj_matches = new java.util.ArrayList();
/* 260 */
/* 261 */     this.smj_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[3];
/* 262 */     smj_result = new UnsafeRow(12);
/* 263 */     this.smj_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(smj_result, 0);
/* 264 */     this.smj_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(smj_holder, 12);
/* 265 */     project_result = new UnsafeRow(11);
/* 266 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 0);
/* 267 */
/* 268 */   }
/* 269 */
/* 270 */   private void wholestagecodegen_init_10() {
/* 271 */     bhj_relation11 = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast11.value()).asReadOnlyCopy();
/* 272 */     incPeakExecutionMemory(bhj_relation11.estimatedSize());
/* 273 */
/* 274 */     this.bhj_numOutputRows11 = (org.apache.spark.sql.execution.metric.SQLMetric) references[27];
/* 275 */     bhj_result11 = new UnsafeRow(21);
/* 276 */     this.bhj_holder11 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result11, 320);
/* 277 */     this.bhj_rowWriter11 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder11, 21);
/* 278 */     project_result12 = new UnsafeRow(19);
/* 279 */     this.project_holder12 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result12, 320);
/* 280 */     this.project_rowWriter12 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder12, 19);
/* 281 */     this.bhj_broadcast12 = (org.apache.spark.broadcast.TorrentBroadcast) references[28];
/* 282 */
/* 283 */     bhj_relation12 = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast12.value()).asReadOnlyCopy();
/* 284 */     incPeakExecutionMemory(bhj_relation12.estimatedSize());
/* 285 */
/* 286 */   }
/* 287 */
/* 288 */   private void wholestagecodegen_init_3() {
/* 289 */     this.bhj_numOutputRows2 = (org.apache.spark.sql.execution.metric.SQLMetric) references[9];
/* 290 */     bhj_result2 = new UnsafeRow(18);
/* 291 */     this.bhj_holder2 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result2, 64);
/* 292 */     this.bhj_rowWriter2 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder2, 18);
/* 293 */     project_result3 = new UnsafeRow(16);
/* 294 */     this.project_holder3 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result3, 64);
/* 295 */     this.project_rowWriter3 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder3, 16);
/* 296 */     this.bhj_broadcast3 = (org.apache.spark.broadcast.TorrentBroadcast) references[10];
/* 297 */
/* 298 */     bhj_relation3 = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast3.value()).asReadOnlyCopy();
/* 299 */     incPeakExecutionMemory(bhj_relation3.estimatedSize());
/* 300 */
/* 301 */     this.bhj_numOutputRows3 = (org.apache.spark.sql.execution.metric.SQLMetric) references[11];
/* 302 */     bhj_result3 = new UnsafeRow(18);
/* 303 */     this.bhj_holder3 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result3, 64);
/* 304 */
/* 305 */   }
/* 306 */
/* 307 */   private void wholestagecodegen_init_12() {
/* 308 */     this.bhj_rowWriter13 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder13, 19);
/* 309 */     project_result14 = new UnsafeRow(17);
/* 310 */     this.project_holder14 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result14, 320);
/* 311 */     this.project_rowWriter14 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder14, 17);
/* 312 */     this.bhj_broadcast14 = (org.apache.spark.broadcast.TorrentBroadcast) references[32];
/* 313 */
/* 314 */     bhj_relation14 = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast14.value()).asReadOnlyCopy();
/* 315 */     incPeakExecutionMemory(bhj_relation14.estimatedSize());
/* 316 */
/* 317 */     this.bhj_numOutputRows14 = (org.apache.spark.sql.execution.metric.SQLMetric) references[33];
/* 318 */     bhj_result14 = new UnsafeRow(19);
/* 319 */     this.bhj_holder14 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result14, 352);
/* 320 */     this.bhj_rowWriter14 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder14, 19);
/* 321 */     project_result15 = new UnsafeRow(18);
/* 322 */
/* 323 */   }
/* 324 */
/* 325 */   private boolean findNextInnerJoinRows(
/* 326 */     scala.collection.Iterator leftIter,
/* 327 */     scala.collection.Iterator rightIter) {
/* 328 */     smj_leftRow = null;
/* 329 */     int comp = 0;
/* 330 */     while (smj_leftRow == null) {
/* 331 */       if (!leftIter.hasNext()) return false;
/* 332 */       smj_leftRow = (InternalRow) leftIter.next();
/* 333 */
/* 334 */       boolean smj_isNull = smj_leftRow.isNullAt(0);
/* 335 */       int smj_value = smj_isNull ? -1 : (smj_leftRow.getInt(0));
/* 336 */       if (smj_isNull) {
/* 337 */         smj_leftRow = null;
/* 338 */         continue;
/* 339 */       }
/* 340 */       if (!smj_matches.isEmpty()) {
/* 341 */         comp = 0;
/* 342 */         if (comp == 0) {
/* 343 */           comp = (smj_value > smj_value3 ? 1 : smj_value < smj_value3 ? -1 : 0);
/* 344 */         }
/* 345 */
/* 346 */         if (comp == 0) {
/* 347 */           return true;
/* 348 */         }
/* 349 */         smj_matches.clear();
/* 350 */       }
/* 351 */
/* 352 */       do {
/* 353 */         if (smj_rightRow == null) {
/* 354 */           if (!rightIter.hasNext()) {
/* 355 */             smj_value3 = smj_value;
/* 356 */             return !smj_matches.isEmpty();
/* 357 */           }
/* 358 */           smj_rightRow = (InternalRow) rightIter.next();
/* 359 */
/* 360 */           boolean smj_isNull1 = smj_rightRow.isNullAt(0);
/* 361 */           int smj_value1 = smj_isNull1 ? -1 : (smj_rightRow.getInt(0));
/* 362 */           if (smj_isNull1) {
/* 363 */             smj_rightRow = null;
/* 364 */             continue;
/* 365 */           }
/* 366 */           smj_value2 = smj_value1;
/* 367 */         }
/* 368 */
/* 369 */         comp = 0;
/* 370 */         if (comp == 0) {
/* 371 */           comp = (smj_value > smj_value2 ? 1 : smj_value < smj_value2 ? -1 : 0);
/* 372 */         }
/* 373 */
/* 374 */         if (comp > 0) {
/* 375 */           smj_rightRow = null;
/* 376 */         } else if (comp < 0) {
/* 377 */           if (!smj_matches.isEmpty()) {
/* 378 */             smj_value3 = smj_value;
/* 379 */             return true;
/* 380 */           }
/* 381 */           smj_leftRow = null;
/* 382 */         } else {
/* 383 */           smj_matches.add(smj_rightRow.copy());
/* 384 */           smj_rightRow = null;;
/* 385 */         }
/* 386 */       } while (smj_leftRow != null);
/* 387 */     }
/* 388 */     return false; // unreachable
/* 389 */   }
/* 390 */
/* 391 */   public class agg_FastHashMap {
/* 392 */     private org.apache.spark.sql.catalyst.expressions.RowBasedKeyValueBatch batch;
/* 393 */     private int[] buckets;
/* 394 */     private int capacity = 1 << 16;
/* 395 */     private double loadFactor = 0.5;
/* 396 */     private int numBuckets = (int) (capacity / loadFactor);
/* 397 */     private int maxSteps = 2;
/* 398 */     private int numRows = 0;
/* 399 */     private org.apache.spark.sql.types.StructType keySchema = new org.apache.spark.sql.types.StructType().add("i_product_name", org.apache.spark.sql.types.DataTypes.StringType)
/* 400 */     .add("i_item_sk", org.apache.spark.sql.types.DataTypes.IntegerType)
/* 401 */     .add("s_store_name", org.apache.spark.sql.types.DataTypes.StringType)
/* 402 */     .add("s_zip", org.apache.spark.sql.types.DataTypes.StringType)
/* 403 */     .add("ca_street_number", org.apache.spark.sql.types.DataTypes.StringType)
/* 404 */     .add("ca_street_name", org.apache.spark.sql.types.DataTypes.StringType)
/* 405 */     .add("ca_city", org.apache.spark.sql.types.DataTypes.StringType)
/* 406 */     .add("ca_zip", org.apache.spark.sql.types.DataTypes.StringType)
/* 407 */     .add("ca_street_number", org.apache.spark.sql.types.DataTypes.StringType)
/* 408 */     .add("ca_street_name", org.apache.spark.sql.types.DataTypes.StringType)
/* 409 */     .add("ca_city", org.apache.spark.sql.types.DataTypes.StringType)
/* 410 */     .add("ca_zip", org.apache.spark.sql.types.DataTypes.StringType)
/* 411 */     .add("d_year", org.apache.spark.sql.types.DataTypes.IntegerType)
/* 412 */     .add("d_year", org.apache.spark.sql.types.DataTypes.IntegerType)
/* 413 */     .add("d_year", org.apache.spark.sql.types.DataTypes.IntegerType);
/* 414 */     private org.apache.spark.sql.types.StructType valueSchema = new org.apache.spark.sql.types.StructType().add("count", org.apache.spark.sql.types.DataTypes.LongType)
/* 415 */     .add("sum", org.apache.spark.sql.types.DataTypes.DoubleType)
/* 416 */     .add("sum", org.apache.spark.sql.types.DataTypes.DoubleType)
/* 417 */     .add("sum", org.apache.spark.sql.types.DataTypes.DoubleType);
/* 418 */     private Object emptyVBase;
/* 419 */     private long emptyVOff;
/* 420 */     private int emptyVLen;
/* 421 */     private boolean isBatchFull = false;
/* 422 */
/* 423 */     public agg_FastHashMap(
/* 424 */       org.apache.spark.memory.TaskMemoryManager taskMemoryManager,
/* 425 */       InternalRow emptyAggregationBuffer) {
/* 426 */       batch = org.apache.spark.sql.catalyst.expressions.RowBasedKeyValueBatch
/* 427 */       .allocate(keySchema, valueSchema, taskMemoryManager, capacity);
/* 428 */
/* 429 */       final UnsafeProjection valueProjection = UnsafeProjection.create(valueSchema);
/* 430 */       final byte[] emptyBuffer = valueProjection.apply(emptyAggregationBuffer).getBytes();
/* 431 */
/* 432 */       emptyVBase = emptyBuffer;
/* 433 */       emptyVOff = Platform.BYTE_ARRAY_OFFSET;
/* 434 */       emptyVLen = emptyBuffer.length;
/* 435 */
/* 436 */       buckets = new int[numBuckets];
/* 437 */       java.util.Arrays.fill(buckets, -1);
/* 438 */     }
/* 439 */
/* 440 */     public org.apache.spark.sql.catalyst.expressions.UnsafeRow findOrInsert(UTF8String agg_key, int agg_key1, UTF8String agg_key2, UTF8String agg_key3, UTF8String agg_key4, UTF8String agg_key5, UTF8String agg_key6, UTF8String agg_key7, UTF8String agg_key8, UTF8String agg_key9, UTF8String agg_key10, UTF8String agg_key11, int agg_key12, int agg_key13, int agg_key14) {
/* 441 */       long h = hash(agg_key, agg_key1, agg_key2, agg_key3, agg_key4, agg_key5, agg_key6, agg_key7, agg_key8, agg_key9, agg_key10, agg_key11, agg_key12, agg_key13, agg_key14);
/* 442 */       int step = 0;
/* 443 */       int idx = (int) h & (numBuckets - 1);
/* 444 */       while (step < maxSteps) {
/* 445 */         // Return bucket index if it's either an empty slot or already contains the key
/* 446 */         if (buckets[idx] == -1) {
/* 447 */           if (numRows < capacity && !isBatchFull) {
/* 448 */             // creating the unsafe for new entry
/* 449 */             UnsafeRow agg_result = new UnsafeRow(15);
/* 450 */             org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder
/* 451 */             = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result,
/* 452 */               352);
/* 453 */             org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter
/* 454 */             = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(
/* 455 */               agg_holder,
/* 456 */               15);
/* 457 */             agg_holder.reset(); //TODO: investigate if reset or zeroout are actually needed
/* 458 */             agg_rowWriter.zeroOutNullBytes();
/* 459 */             agg_rowWriter.write(0, agg_key);
/* 460 */             agg_rowWriter.write(1, agg_key1);
/* 461 */             agg_rowWriter.write(2, agg_key2);
/* 462 */             agg_rowWriter.write(3, agg_key3);
/* 463 */             agg_rowWriter.write(4, agg_key4);
/* 464 */             agg_rowWriter.write(5, agg_key5);
/* 465 */             agg_rowWriter.write(6, agg_key6);
/* 466 */             agg_rowWriter.write(7, agg_key7);
/* 467 */             agg_rowWriter.write(8, agg_key8);
/* 468 */             agg_rowWriter.write(9, agg_key9);
/* 469 */             agg_rowWriter.write(10, agg_key10);
/* 470 */             agg_rowWriter.write(11, agg_key11);
/* 471 */             agg_rowWriter.write(12, agg_key12);
/* 472 */             agg_rowWriter.write(13, agg_key13);
/* 473 */             agg_rowWriter.write(14, agg_key14);
/* 474 */             agg_result.setTotalSize(agg_holder.totalSize());
/* 475 */             Object kbase = agg_result.getBaseObject();
/* 476 */             long koff = agg_result.getBaseOffset();
/* 477 */             int klen = agg_result.getSizeInBytes();
/* 478 */
/* 479 */             UnsafeRow vRow
/* 480 */             = batch.appendRow(kbase, koff, klen, emptyVBase, emptyVOff, emptyVLen);
/* 481 */             if (vRow == null) {
/* 482 */               isBatchFull = true;
/* 483 */             } else {
/* 484 */               buckets[idx] = numRows++;
/* 485 */             }
/* 486 */             return vRow;
/* 487 */           } else {
/* 488 */             // No more space
/* 489 */             return null;
/* 490 */           }
/* 491 */         } else if (equals(idx, agg_key, agg_key1, agg_key2, agg_key3, agg_key4, agg_key5, agg_key6, agg_key7, agg_key8, agg_key9, agg_key10, agg_key11, agg_key12, agg_key13, agg_key14)) {
/* 492 */           return batch.getValueRow(buckets[idx]);
/* 493 */         }
/* 494 */         idx = (idx + 1) & (numBuckets - 1);
/* 495 */         step++;
/* 496 */       }
/* 497 */       // Didn't find it
/* 498 */       return null;
/* 499 */     }
/* 500 */
/* 501 */     private boolean equals(int idx, UTF8String agg_key, int agg_key1, UTF8String agg_key2, UTF8String agg_key3, UTF8String agg_key4, UTF8String agg_key5, UTF8String agg_key6, UTF8String agg_key7, UTF8String agg_key8, UTF8String agg_key9, UTF8String agg_key10, UTF8String agg_key11, int agg_key12, int agg_key13, int agg_key14) {
/* 502 */       UnsafeRow row = batch.getKeyRow(buckets[idx]);
/* 503 */       return (row.getUTF8String(0).equals(agg_key)) && (row.getInt(1) == agg_key1) && (row.getUTF8String(2).equals(agg_key2)) && (row.getUTF8String(3).equals(agg_key3)) && (row.getUTF8String(4).equals(agg_key4)) && (row.getUTF8String(5).equals(agg_key5)) && (row.getUTF8String(6).equals(agg_key6)) && (row.getUTF8String(7).equals(agg_key7)) && (row.getUTF8String(8).equals(agg_key8)) && (row.getUTF8String(9).equals(agg_key9)) && (row.getUTF8String(10).equals(agg_key10)) && (row.getUTF8String(11).equals(agg_key11)) && (row.getInt(12) == agg_key12) && (row.getInt(13) == agg_key13) && (row.getInt(14) == agg_key14);
/* 504 */     }
/* 505 */
/* 506 */     private long hash(UTF8String agg_key, int agg_key1, UTF8String agg_key2, UTF8String agg_key3, UTF8String agg_key4, UTF8String agg_key5, UTF8String agg_key6, UTF8String agg_key7, UTF8String agg_key8, UTF8String agg_key9, UTF8String agg_key10, UTF8String agg_key11, int agg_key12, int agg_key13, int agg_key14) {
/* 507 */       long agg_hash = 0;
/* 508 */
/* 509 */       int agg_result = 0;
/* 510 */       byte[] agg_bytes = agg_key.getBytes();
/* 511 */       for (int i = 0; i < agg_bytes.length; i++) {
/* 512 */         int agg_hash1 = agg_bytes[i];
/* 513 */         agg_result = (agg_result ^ (0x9e3779b9)) + agg_hash1 + (agg_result << 6) + (agg_result >>> 2);
/* 514 */       }
/* 515 */
/* 516 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result + (agg_hash << 6) + (agg_hash >>> 2);
/* 517 */
/* 518 */       int agg_result1 = agg_key1;
/* 519 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result1 + (agg_hash << 6) + (agg_hash >>> 2);
/* 520 */
/* 521 */       int agg_result2 = 0;
/* 522 */       byte[] agg_bytes1 = agg_key2.getBytes();
/* 523 */       for (int i = 0; i < agg_bytes1.length; i++) {
/* 524 */         int agg_hash2 = agg_bytes1[i];
/* 525 */         agg_result2 = (agg_result2 ^ (0x9e3779b9)) + agg_hash2 + (agg_result2 << 6) + (agg_result2 >>> 2);
/* 526 */       }
/* 527 */
/* 528 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result2 + (agg_hash << 6) + (agg_hash >>> 2);
/* 529 */
/* 530 */       int agg_result3 = 0;
/* 531 */       byte[] agg_bytes2 = agg_key3.getBytes();
/* 532 */       for (int i = 0; i < agg_bytes2.length; i++) {
/* 533 */         int agg_hash3 = agg_bytes2[i];
/* 534 */         agg_result3 = (agg_result3 ^ (0x9e3779b9)) + agg_hash3 + (agg_result3 << 6) + (agg_result3 >>> 2);
/* 535 */       }
/* 536 */
/* 537 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result3 + (agg_hash << 6) + (agg_hash >>> 2);
/* 538 */
/* 539 */       int agg_result4 = 0;
/* 540 */       byte[] agg_bytes3 = agg_key4.getBytes();
/* 541 */       for (int i = 0; i < agg_bytes3.length; i++) {
/* 542 */         int agg_hash4 = agg_bytes3[i];
/* 543 */         agg_result4 = (agg_result4 ^ (0x9e3779b9)) + agg_hash4 + (agg_result4 << 6) + (agg_result4 >>> 2);
/* 544 */       }
/* 545 */
/* 546 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result4 + (agg_hash << 6) + (agg_hash >>> 2);
/* 547 */
/* 548 */       int agg_result5 = 0;
/* 549 */       byte[] agg_bytes4 = agg_key5.getBytes();
/* 550 */       for (int i = 0; i < agg_bytes4.length; i++) {
/* 551 */         int agg_hash5 = agg_bytes4[i];
/* 552 */         agg_result5 = (agg_result5 ^ (0x9e3779b9)) + agg_hash5 + (agg_result5 << 6) + (agg_result5 >>> 2);
/* 553 */       }
/* 554 */
/* 555 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result5 + (agg_hash << 6) + (agg_hash >>> 2);
/* 556 */
/* 557 */       int agg_result6 = 0;
/* 558 */       byte[] agg_bytes5 = agg_key6.getBytes();
/* 559 */       for (int i = 0; i < agg_bytes5.length; i++) {
/* 560 */         int agg_hash6 = agg_bytes5[i];
/* 561 */         agg_result6 = (agg_result6 ^ (0x9e3779b9)) + agg_hash6 + (agg_result6 << 6) + (agg_result6 >>> 2);
/* 562 */       }
/* 563 */
/* 564 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result6 + (agg_hash << 6) + (agg_hash >>> 2);
/* 565 */
/* 566 */       int agg_result7 = 0;
/* 567 */       byte[] agg_bytes6 = agg_key7.getBytes();
/* 568 */       for (int i = 0; i < agg_bytes6.length; i++) {
/* 569 */         int agg_hash7 = agg_bytes6[i];
/* 570 */         agg_result7 = (agg_result7 ^ (0x9e3779b9)) + agg_hash7 + (agg_result7 << 6) + (agg_result7 >>> 2);
/* 571 */       }
/* 572 */
/* 573 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result7 + (agg_hash << 6) + (agg_hash >>> 2);
/* 574 */
/* 575 */       int agg_result8 = 0;
/* 576 */       byte[] agg_bytes7 = agg_key8.getBytes();
/* 577 */       for (int i = 0; i < agg_bytes7.length; i++) {
/* 578 */         int agg_hash8 = agg_bytes7[i];
/* 579 */         agg_result8 = (agg_result8 ^ (0x9e3779b9)) + agg_hash8 + (agg_result8 << 6) + (agg_result8 >>> 2);
/* 580 */       }
/* 581 */
/* 582 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result8 + (agg_hash << 6) + (agg_hash >>> 2);
/* 583 */
/* 584 */       int agg_result9 = 0;
/* 585 */       byte[] agg_bytes8 = agg_key9.getBytes();
/* 586 */       for (int i = 0; i < agg_bytes8.length; i++) {
/* 587 */         int agg_hash9 = agg_bytes8[i];
/* 588 */         agg_result9 = (agg_result9 ^ (0x9e3779b9)) + agg_hash9 + (agg_result9 << 6) + (agg_result9 >>> 2);
/* 589 */       }
/* 590 */
/* 591 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result9 + (agg_hash << 6) + (agg_hash >>> 2);
/* 592 */
/* 593 */       int agg_result10 = 0;
/* 594 */       byte[] agg_bytes9 = agg_key10.getBytes();
/* 595 */       for (int i = 0; i < agg_bytes9.length; i++) {
/* 596 */         int agg_hash10 = agg_bytes9[i];
/* 597 */         agg_result10 = (agg_result10 ^ (0x9e3779b9)) + agg_hash10 + (agg_result10 << 6) + (agg_result10 >>> 2);
/* 598 */       }
/* 599 */
/* 600 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result10 + (agg_hash << 6) + (agg_hash >>> 2);
/* 601 */
/* 602 */       int agg_result11 = 0;
/* 603 */       byte[] agg_bytes10 = agg_key11.getBytes();
/* 604 */       for (int i = 0; i < agg_bytes10.length; i++) {
/* 605 */         int agg_hash11 = agg_bytes10[i];
/* 606 */         agg_result11 = (agg_result11 ^ (0x9e3779b9)) + agg_hash11 + (agg_result11 << 6) + (agg_result11 >>> 2);
/* 607 */       }
/* 608 */
/* 609 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result11 + (agg_hash << 6) + (agg_hash >>> 2);
/* 610 */
/* 611 */       int agg_result12 = agg_key12;
/* 612 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result12 + (agg_hash << 6) + (agg_hash >>> 2);
/* 613 */
/* 614 */       int agg_result13 = agg_key13;
/* 615 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result13 + (agg_hash << 6) + (agg_hash >>> 2);
/* 616 */
/* 617 */       int agg_result14 = agg_key14;
/* 618 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result14 + (agg_hash << 6) + (agg_hash >>> 2);
/* 619 */
/* 620 */       return agg_hash;
/* 621 */     }
/* 622 */
/* 623 */     public org.apache.spark.unsafe.KVIterator<UnsafeRow, UnsafeRow> rowIterator() {
/* 624 */       return batch.rowIterator();
/* 625 */     }
/* 626 */
/* 627 */     public void close() {
/* 628 */       batch.close();
/* 629 */     }
/* 630 */
/* 631 */   }
/* 632 */
/* 633 */   private void agg_doAggregateWithKeys() throws java.io.IOException {
/* 634 */     agg_hashMap = agg_plan.createHashMap();
/* 635 */
/* 636 */     while (findNextInnerJoinRows(smj_leftInput, smj_rightInput)) {
/* 637 */       int smj_size = smj_matches.size();
/* 638 */       smj_isNull2 = smj_leftRow.isNullAt(0);
/* 639 */       smj_value4 = smj_isNull2 ? -1 : (smj_leftRow.getInt(0));
/* 640 */       smj_isNull3 = smj_leftRow.isNullAt(1);
/* 641 */       smj_value5 = smj_isNull3 ? -1 : (smj_leftRow.getInt(1));
/* 642 */       smj_isNull4 = smj_leftRow.isNullAt(2);
/* 643 */       smj_value6 = smj_isNull4 ? -1 : (smj_leftRow.getInt(2));
/* 644 */       smj_isNull5 = smj_leftRow.isNullAt(3);
/* 645 */       smj_value7 = smj_isNull5 ? -1 : (smj_leftRow.getInt(3));
/* 646 */       smj_isNull6 = smj_leftRow.isNullAt(4);
/* 647 */       smj_value8 = smj_isNull6 ? -1 : (smj_leftRow.getInt(4));
/* 648 */       smj_isNull7 = smj_leftRow.isNullAt(5);
/* 649 */       smj_value9 = smj_isNull7 ? -1 : (smj_leftRow.getInt(5));
/* 650 */       smj_isNull8 = smj_leftRow.isNullAt(6);
/* 651 */       smj_value10 = smj_isNull8 ? -1 : (smj_leftRow.getInt(6));
/* 652 */       smj_isNull9 = smj_leftRow.isNullAt(7);
/* 653 */       smj_value11 = smj_isNull9 ? -1.0 : (smj_leftRow.getDouble(7));
/* 654 */       smj_isNull10 = smj_leftRow.isNullAt(8);
/* 655 */       smj_value12 = smj_isNull10 ? -1.0 : (smj_leftRow.getDouble(8));
/* 656 */       smj_isNull11 = smj_leftRow.isNullAt(9);
/* 657 */       smj_value13 = smj_isNull11 ? -1.0 : (smj_leftRow.getDouble(9));
/* 658 */       smj_isNull12 = smj_leftRow.isNullAt(10);
/* 659 */       smj_value14 = smj_isNull12 ? -1 : (smj_leftRow.getInt(10));
/* 660 */       for (int smj_i = 0; smj_i < smj_size; smj_i ++) {
/* 661 */         InternalRow smj_rightRow1 = (InternalRow) smj_matches.get(smj_i);
/* 662 */
/* 663 */         smj_numOutputRows.add(1);
/* 664 */
/* 665 */         // generate join key for stream side
/* 666 */
/* 667 */         boolean bhj_isNull = smj_isNull12;
/* 668 */         long bhj_value = -1L;
/* 669 */         if (!smj_isNull12) {
/* 670 */           bhj_value = (long) smj_value14;
/* 671 */         }
/* 672 */         // find matches from HashedRelation
/* 673 */         UnsafeRow bhj_matched = bhj_isNull ? null: (UnsafeRow)bhj_relation.getValue(bhj_value);
/* 674 */         if (bhj_matched == null) continue;
/* 675 */
/* 676 */         bhj_numOutputRows.add(1);
/* 677 */
/* 678 */         // generate join key for stream side
/* 679 */
/* 680 */         boolean bhj_isNull17 = smj_isNull7;
/* 681 */         long bhj_value17 = -1L;
/* 682 */         if (!smj_isNull7) {
/* 683 */           bhj_value17 = (long) smj_value9;
/* 684 */         }
/* 685 */         // find matches from HashedRelation
/* 686 */         UnsafeRow bhj_matched1 = bhj_isNull17 ? null: (UnsafeRow)bhj_relation1.getValue(bhj_value17);
/* 687 */         if (bhj_matched1 == null) continue;
/* 688 */
/* 689 */         bhj_numOutputRows1.add(1);
/* 690 */
/* 691 */         // generate join key for stream side
/* 692 */
/* 693 */         boolean bhj_isNull36 = smj_isNull3;
/* 694 */         long bhj_value36 = -1L;
/* 695 */         if (!smj_isNull3) {
/* 696 */           bhj_value36 = (long) smj_value5;
/* 697 */         }
/* 698 */         // find matches from HashedRelation
/* 699 */         UnsafeRow bhj_matched2 = bhj_isNull36 ? null: (UnsafeRow)bhj_relation2.getValue(bhj_value36);
/* 700 */         if (bhj_matched2 == null) continue;
/* 701 */
/* 702 */         bhj_numOutputRows2.add(1);
/* 703 */
/* 704 */         boolean bhj_isNull43 = bhj_matched2.isNullAt(5);
/* 705 */         int bhj_value43 = bhj_isNull43 ? -1 : (bhj_matched2.getInt(5));
/* 706 */
/* 707 */         // generate join key for stream side
/* 708 */
/* 709 */         boolean bhj_isNull62 = bhj_isNull43;
/* 710 */         long bhj_value62 = -1L;
/* 711 */         if (!bhj_isNull43) {
/* 712 */           bhj_value62 = (long) bhj_value43;
/* 713 */         }
/* 714 */         // find matches from HashedRelation
/* 715 */         UnsafeRow bhj_matched3 = bhj_isNull62 ? null: (UnsafeRow)bhj_relation3.getValue(bhj_value62);
/* 716 */         if (bhj_matched3 == null) continue;
/* 717 */
/* 718 */         bhj_numOutputRows3.add(1);
/* 719 */
/* 720 */         boolean bhj_isNull42 = bhj_matched2.isNullAt(4);
/* 721 */         int bhj_value42 = bhj_isNull42 ? -1 : (bhj_matched2.getInt(4));
/* 722 */
/* 723 */         // generate join key for stream side
/* 724 */
/* 725 */         boolean bhj_isNull84 = bhj_isNull42;
/* 726 */         long bhj_value84 = -1L;
/* 727 */         if (!bhj_isNull42) {
/* 728 */           bhj_value84 = (long) bhj_value42;
/* 729 */         }
/* 730 */         // find matches from HashedRelation
/* 731 */         UnsafeRow bhj_matched4 = bhj_isNull84 ? null: (UnsafeRow)bhj_relation4.getValue(bhj_value84);
/* 732 */         if (bhj_matched4 == null) continue;
/* 733 */
/* 734 */         bhj_numOutputRows4.add(1);
/* 735 */
/* 736 */         // generate join key for stream side
/* 737 */
/* 738 */         boolean bhj_isNull106 = smj_isNull4;
/* 739 */         long bhj_value106 = -1L;
/* 740 */         if (!smj_isNull4) {
/* 741 */           bhj_value106 = (long) smj_value6;
/* 742 */         }
/* 743 */         // find matches from HashedRelation
/* 744 */         UnsafeRow bhj_matched5 = bhj_isNull106 ? null: (UnsafeRow)bhj_relation5.getValue(bhj_value106);
/* 745 */         if (bhj_matched5 == null) continue;
/* 746 */
/* 747 */         bhj_numOutputRows5.add(1);
/* 748 */
/* 749 */         boolean bhj_isNull39 = bhj_matched2.isNullAt(1);
/* 750 */         int bhj_value39 = bhj_isNull39 ? -1 : (bhj_matched2.getInt(1));
/* 751 */         boolean bhj_isNull109 = bhj_matched5.isNullAt(1);
/* 752 */         UTF8String bhj_value109 = bhj_isNull109 ? null : (bhj_matched5.getUTF8String(1));
/* 753 */
/* 754 */         // generate join key for stream side
/* 755 */
/* 756 */         boolean bhj_isNull128 = bhj_isNull39;
/* 757 */         long bhj_value128 = -1L;
/* 758 */         if (!bhj_isNull39) {
/* 759 */           bhj_value128 = (long) bhj_value39;
/* 760 */         }
/* 761 */         // find matches from HashedRelation
/* 762 */         UnsafeRow bhj_matched6 = bhj_isNull128 ? null: (UnsafeRow)bhj_relation6.getValue(bhj_value128);
/* 763 */         if (bhj_matched6 == null) continue;
/* 764 */
/* 765 */         boolean bhj_isNull131 = bhj_matched6.isNullAt(1);
/* 766 */         UTF8String bhj_value131 = bhj_isNull131 ? null : (bhj_matched6.getUTF8String(1));
/* 767 */
/* 768 */         boolean bhj_isNull133 = true;
/* 769 */         boolean bhj_value133 = false;
/* 770 */
/* 771 */         if (!bhj_isNull109) {
/* 772 */           if (!bhj_isNull131) {
/* 773 */             bhj_isNull133 = false; // resultCode could change nullability.
/* 774 */             bhj_value133 = bhj_value109.equals(bhj_value131);
/* 775 */
/* 776 */           }
/* 777 */
/* 778 */         }
/* 779 */         boolean bhj_isNull132 = bhj_isNull133;
/* 780 */         boolean bhj_value132 = false;
/* 781 */
/* 782 */         if (!bhj_isNull133) {
/* 783 */           bhj_value132 = !(bhj_value133);
/* 784 */         }
/* 785 */         if (bhj_isNull132 || !bhj_value132) continue;
/* 786 */
/* 787 */         bhj_numOutputRows6.add(1);
/* 788 */
/* 789 */         // generate join key for stream side
/* 790 */
/* 791 */         boolean bhj_isNull154 = smj_isNull8;
/* 792 */         long bhj_value154 = -1L;
/* 793 */         if (!smj_isNull8) {
/* 794 */           bhj_value154 = (long) smj_value10;
/* 795 */         }
/* 796 */         // find matches from HashedRelation
/* 797 */         UnsafeRow bhj_matched7 = bhj_isNull154 ? null: (UnsafeRow)bhj_relation7.getValue(bhj_value154);
/* 798 */         if (bhj_matched7 == null) continue;
/* 799 */
/* 800 */         bhj_numOutputRows7.add(1);
/* 801 */
/* 802 */         // generate join key for stream side
/* 803 */
/* 804 */         boolean bhj_isNull172 = smj_isNull5;
/* 805 */         long bhj_value172 = -1L;
/* 806 */         if (!smj_isNull5) {
/* 807 */           bhj_value172 = (long) smj_value7;
/* 808 */         }
/* 809 */         // find matches from HashedRelation
/* 810 */         UnsafeRow bhj_matched8 = bhj_isNull172 ? null: (UnsafeRow)bhj_relation8.getValue(bhj_value172);
/* 811 */         if (bhj_matched8 == null) continue;
/* 812 */
/* 813 */         bhj_numOutputRows8.add(1);
/* 814 */
/* 815 */         boolean bhj_isNull40 = bhj_matched2.isNullAt(2);
/* 816 */         int bhj_value40 = bhj_isNull40 ? -1 : (bhj_matched2.getInt(2));
/* 817 */
/* 818 */         // generate join key for stream side
/* 819 */
/* 820 */         boolean bhj_isNull191 = bhj_isNull40;
/* 821 */         long bhj_value191 = -1L;
/* 822 */         if (!bhj_isNull40) {
/* 823 */           bhj_value191 = (long) bhj_value40;
/* 824 */         }
/* 825 */         // find matches from HashedRelation
/* 826 */         UnsafeRow bhj_matched9 = bhj_isNull191 ? null: (UnsafeRow)bhj_relation9.getValue(bhj_value191);
/* 827 */         if (bhj_matched9 == null) continue;
/* 828 */
/* 829 */         bhj_numOutputRows9.add(1);
/* 830 */
/* 831 */         // generate join key for stream side
/* 832 */
/* 833 */         boolean bhj_isNull210 = smj_isNull6;
/* 834 */         long bhj_value210 = -1L;
/* 835 */         if (!smj_isNull6) {
/* 836 */           bhj_value210 = (long) smj_value8;
/* 837 */         }
/* 838 */         // find matches from HashedRelation
/* 839 */         UnsafeRow bhj_matched10 = bhj_isNull210 ? null: (UnsafeRow)bhj_relation10.getValue(bhj_value210);
/* 840 */         if (bhj_matched10 == null) continue;
/* 841 */
/* 842 */         bhj_numOutputRows10.add(1);
/* 843 */
/* 844 */         boolean bhj_isNull41 = bhj_matched2.isNullAt(3);
/* 845 */         int bhj_value41 = bhj_isNull41 ? -1 : (bhj_matched2.getInt(3));
/* 846 */
/* 847 */         // generate join key for stream side
/* 848 */
/* 849 */         boolean bhj_isNull235 = bhj_isNull41;
/* 850 */         long bhj_value235 = -1L;
/* 851 */         if (!bhj_isNull41) {
/* 852 */           bhj_value235 = (long) bhj_value41;
/* 853 */         }
/* 854 */         // find matches from HashedRelation
/* 855 */         UnsafeRow bhj_matched11 = bhj_isNull235 ? null: (UnsafeRow)bhj_relation11.getValue(bhj_value235);
/* 856 */         if (bhj_matched11 == null) continue;
/* 857 */
/* 858 */         bhj_numOutputRows11.add(1);
/* 859 */
/* 860 */         boolean bhj_isNull175 = bhj_matched8.isNullAt(1);
/* 861 */         int bhj_value175 = bhj_isNull175 ? -1 : (bhj_matched8.getInt(1));
/* 862 */
/* 863 */         // generate join key for stream side
/* 864 */
/* 865 */         boolean bhj_isNull263 = bhj_isNull175;
/* 866 */         long bhj_value263 = -1L;
/* 867 */         if (!bhj_isNull175) {
/* 868 */           bhj_value263 = (long) bhj_value175;
/* 869 */         }
/* 870 */         // find matches from HashedRelation
/* 871 */         UnsafeRow bhj_matched12 = bhj_isNull263 ? null: (UnsafeRow)bhj_relation12.getValue(bhj_value263);
/* 872 */         if (bhj_matched12 == null) continue;
/* 873 */
/* 874 */         bhj_numOutputRows12.add(1);
/* 875 */
/* 876 */         boolean bhj_isNull194 = bhj_matched9.isNullAt(1);
/* 877 */         int bhj_value194 = bhj_isNull194 ? -1 : (bhj_matched9.getInt(1));
/* 878 */
/* 879 */         // generate join key for stream side
/* 880 */
/* 881 */         boolean bhj_isNull286 = bhj_isNull194;
/* 882 */         long bhj_value286 = -1L;
/* 883 */         if (!bhj_isNull194) {
/* 884 */           bhj_value286 = (long) bhj_value194;
/* 885 */         }
/* 886 */         // find matches from HashedRelation
/* 887 */         UnsafeRow bhj_matched13 = bhj_isNull286 ? null: (UnsafeRow)bhj_relation13.getValue(bhj_value286);
/* 888 */         if (bhj_matched13 == null) continue;
/* 889 */
/* 890 */         bhj_numOutputRows13.add(1);
/* 891 */
/* 892 */         // generate join key for stream side
/* 893 */
/* 894 */         boolean bhj_isNull308 = smj_isNull2;
/* 895 */         long bhj_value308 = -1L;
/* 896 */         if (!smj_isNull2) {
/* 897 */           bhj_value308 = (long) smj_value4;
/* 898 */         }
/* 899 */         // find matches from HashedRelation
/* 900 */         UnsafeRow bhj_matched14 = bhj_isNull308 ? null: (UnsafeRow)bhj_relation14.getValue(bhj_value308);
/* 901 */         if (bhj_matched14 == null) continue;
/* 902 */
/* 903 */         bhj_numOutputRows14.add(1);
/* 904 */
/* 905 */         boolean bhj_isNull3 = bhj_matched.isNullAt(1);
/* 906 */         int bhj_value3 = bhj_isNull3 ? -1 : (bhj_matched.getInt(1));
/* 907 */         boolean bhj_isNull20 = bhj_matched1.isNullAt(1);
/* 908 */         UTF8String bhj_value20 = bhj_isNull20 ? null : (bhj_matched1.getUTF8String(1));
/* 909 */         boolean bhj_isNull21 = bhj_matched1.isNullAt(2);
/* 910 */         UTF8String bhj_value21 = bhj_isNull21 ? null : (bhj_matched1.getUTF8String(2));
/* 911 */         boolean bhj_isNull65 = bhj_matched3.isNullAt(1);
/* 912 */         int bhj_value65 = bhj_isNull65 ? -1 : (bhj_matched3.getInt(1));
/* 913 */         boolean bhj_isNull87 = bhj_matched4.isNullAt(1);
/* 914 */         int bhj_value87 = bhj_isNull87 ? -1 : (bhj_matched4.getInt(1));
/* 915 */         boolean bhj_isNull213 = bhj_matched10.isNullAt(1);
/* 916 */         UTF8String bhj_value213 = bhj_isNull213 ? null : (bhj_matched10.getUTF8String(1));
/* 917 */         boolean bhj_isNull214 = bhj_matched10.isNullAt(2);
/* 918 */         UTF8String bhj_value214 = bhj_isNull214 ? null : (bhj_matched10.getUTF8String(2));
/* 919 */         boolean bhj_isNull215 = bhj_matched10.isNullAt(3);
/* 920 */         UTF8String bhj_value215 = bhj_isNull215 ? null : (bhj_matched10.getUTF8String(3));
/* 921 */         boolean bhj_isNull216 = bhj_matched10.isNullAt(4);
/* 922 */         UTF8String bhj_value216 = bhj_isNull216 ? null : (bhj_matched10.getUTF8String(4));
/* 923 */         boolean bhj_isNull238 = bhj_matched11.isNullAt(1);
/* 924 */         UTF8String bhj_value238 = bhj_isNull238 ? null : (bhj_matched11.getUTF8String(1));
/* 925 */         boolean bhj_isNull239 = bhj_matched11.isNullAt(2);
/* 926 */         UTF8String bhj_value239 = bhj_isNull239 ? null : (bhj_matched11.getUTF8String(2));
/* 927 */         boolean bhj_isNull240 = bhj_matched11.isNullAt(3);
/* 928 */         UTF8String bhj_value240 = bhj_isNull240 ? null : (bhj_matched11.getUTF8String(3));
/* 929 */         boolean bhj_isNull241 = bhj_matched11.isNullAt(4);
/* 930 */         UTF8String bhj_value241 = bhj_isNull241 ? null : (bhj_matched11.getUTF8String(4));
/* 931 */         boolean bhj_isNull310 = bhj_matched14.isNullAt(0);
/* 932 */         int bhj_value310 = bhj_isNull310 ? -1 : (bhj_matched14.getInt(0));
/* 933 */         boolean bhj_isNull311 = bhj_matched14.isNullAt(1);
/* 934 */         UTF8String bhj_value311 = bhj_isNull311 ? null : (bhj_matched14.getUTF8String(1));
/* 935 */
/* 936 */         UnsafeRow agg_unsafeRowAggBuffer = null;
/* 937 */
/* 938 */         UnsafeRow agg_fastAggBuffer = null;
/* 939 */
/* 940 */         if (true) {
/* 941 */           if (!bhj_isNull311 && !bhj_isNull310 && !bhj_isNull20 && !bhj_isNull21 && !bhj_isNull213 && !bhj_isNull214 && !bhj_isNull215 && !bhj_isNull216 && !bhj_isNull238 && !bhj_isNull239 && !bhj_isNull240 && !bhj_isNull241 && !bhj_isNull3 && !bhj_isNull65 && !bhj_isNull87) {
/* 942 */             agg_fastAggBuffer = agg_fastHashMap.findOrInsert(
/* 943 */               bhj_value311, bhj_value310, bhj_value20, bhj_value21, bhj_value213, bhj_value214, bhj_value215, bhj_value216, bhj_value238, bhj_value239, bhj_value240, bhj_value241, bhj_value3, bhj_value65, bhj_value87);
/* 944 */           }
/* 945 */         }
/* 946 */
/* 947 */         if (agg_fastAggBuffer == null) {
/* 948 */           // generate grouping key
/* 949 */           agg_holder.reset();
/* 950 */
/* 951 */           agg_rowWriter.zeroOutNullBytes();
/* 952 */
/* 953 */           if (bhj_isNull311) {
/* 954 */             agg_rowWriter.setNullAt(0);
/* 955 */           } else {
/* 956 */             agg_rowWriter.write(0, bhj_value311);
/* 957 */           }
/* 958 */
/* 959 */           if (bhj_isNull310) {
/* 960 */             agg_rowWriter.setNullAt(1);
/* 961 */           } else {
/* 962 */             agg_rowWriter.write(1, bhj_value310);
/* 963 */           }
/* 964 */
/* 965 */           if (bhj_isNull20) {
/* 966 */             agg_rowWriter.setNullAt(2);
/* 967 */           } else {
/* 968 */             agg_rowWriter.write(2, bhj_value20);
/* 969 */           }
/* 970 */
/* 971 */           if (bhj_isNull21) {
/* 972 */             agg_rowWriter.setNullAt(3);
/* 973 */           } else {
/* 974 */             agg_rowWriter.write(3, bhj_value21);
/* 975 */           }
/* 976 */
/* 977 */           if (bhj_isNull213) {
/* 978 */             agg_rowWriter.setNullAt(4);
/* 979 */           } else {
/* 980 */             agg_rowWriter.write(4, bhj_value213);
/* 981 */           }
/* 982 */
/* 983 */           if (bhj_isNull214) {
/* 984 */             agg_rowWriter.setNullAt(5);
/* 985 */           } else {
/* 986 */             agg_rowWriter.write(5, bhj_value214);
/* 987 */           }
/* 988 */
/* 989 */           if (bhj_isNull215) {
/* 990 */             agg_rowWriter.setNullAt(6);
/* 991 */           } else {
/* 992 */             agg_rowWriter.write(6, bhj_value215);
/* 993 */           }
/* 994 */
/* 995 */           if (bhj_isNull216) {
/* 996 */             agg_rowWriter.setNullAt(7);
/* 997 */           } else {
/* 998 */             agg_rowWriter.write(7, bhj_value216);
/* 999 */           }
/* 1000 */
/* 1001 */           if (bhj_isNull238) {
/* 1002 */             agg_rowWriter.setNullAt(8);
/* 1003 */           } else {
/* 1004 */             agg_rowWriter.write(8, bhj_value238);
/* 1005 */           }
/* 1006 */
/* 1007 */           if (bhj_isNull239) {
/* 1008 */             agg_rowWriter.setNullAt(9);
/* 1009 */           } else {
/* 1010 */             agg_rowWriter.write(9, bhj_value239);
/* 1011 */           }
/* 1012 */
/* 1013 */           if (bhj_isNull240) {
/* 1014 */             agg_rowWriter.setNullAt(10);
/* 1015 */           } else {
/* 1016 */             agg_rowWriter.write(10, bhj_value240);
/* 1017 */           }
/* 1018 */
/* 1019 */           if (bhj_isNull241) {
/* 1020 */             agg_rowWriter.setNullAt(11);
/* 1021 */           } else {
/* 1022 */             agg_rowWriter.write(11, bhj_value241);
/* 1023 */           }
/* 1024 */
/* 1025 */           if (bhj_isNull3) {
/* 1026 */             agg_rowWriter.setNullAt(12);
/* 1027 */           } else {
/* 1028 */             agg_rowWriter.write(12, bhj_value3);
/* 1029 */           }
/* 1030 */
/* 1031 */           if (bhj_isNull65) {
/* 1032 */             agg_rowWriter.setNullAt(13);
/* 1033 */           } else {
/* 1034 */             agg_rowWriter.write(13, bhj_value65);
/* 1035 */           }
/* 1036 */
/* 1037 */           if (bhj_isNull87) {
/* 1038 */             agg_rowWriter.setNullAt(14);
/* 1039 */           } else {
/* 1040 */             agg_rowWriter.write(14, bhj_value87);
/* 1041 */           }
/* 1042 */           agg_result15.setTotalSize(agg_holder.totalSize());
/* 1043 */           agg_value38 = 42;
/* 1044 */
/* 1045 */           if (!bhj_isNull311) {
/* 1046 */             agg_value38 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(bhj_value311.getBaseObject(), bhj_value311.getBaseOffset(), bhj_value311.numBytes(), agg_value38);
/* 1047 */           }
/* 1048 */
/* 1049 */           if (!bhj_isNull310) {
/* 1050 */             agg_value38 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(bhj_value310, agg_value38);
/* 1051 */           }
/* 1052 */
/* 1053 */           if (!bhj_isNull20) {
/* 1054 */             agg_value38 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(bhj_value20.getBaseObject(), bhj_value20.getBaseOffset(), bhj_value20.numBytes(), agg_value38);
/* 1055 */           }
/* 1056 */
/* 1057 */           if (!bhj_isNull21) {
/* 1058 */             agg_value38 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(bhj_value21.getBaseObject(), bhj_value21.getBaseOffset(), bhj_value21.numBytes(), agg_value38);
/* 1059 */           }
/* 1060 */
/* 1061 */           if (!bhj_isNull213) {
/* 1062 */             agg_value38 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(bhj_value213.getBaseObject(), bhj_value213.getBaseOffset(), bhj_value213.numBytes(), agg_value38);
/* 1063 */           }
/* 1064 */
/* 1065 */           if (!bhj_isNull214) {
/* 1066 */             agg_value38 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(bhj_value214.getBaseObject(), bhj_value214.getBaseOffset(), bhj_value214.numBytes(), agg_value38);
/* 1067 */           }
/* 1068 */
/* 1069 */           if (!bhj_isNull215) {
/* 1070 */             agg_value38 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(bhj_value215.getBaseObject(), bhj_value215.getBaseOffset(), bhj_value215.numBytes(), agg_value38);
/* 1071 */           }
/* 1072 */
/* 1073 */           if (!bhj_isNull216) {
/* 1074 */             agg_value38 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(bhj_value216.getBaseObject(), bhj_value216.getBaseOffset(), bhj_value216.numBytes(), agg_value38);
/* 1075 */           }
/* 1076 */
/* 1077 */           if (!bhj_isNull238) {
/* 1078 */             agg_value38 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(bhj_value238.getBaseObject(), bhj_value238.getBaseOffset(), bhj_value238.numBytes(), agg_value38);
/* 1079 */           }
/* 1080 */
/* 1081 */           if (!bhj_isNull239) {
/* 1082 */             agg_value38 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(bhj_value239.getBaseObject(), bhj_value239.getBaseOffset(), bhj_value239.numBytes(), agg_value38);
/* 1083 */           }
/* 1084 */
/* 1085 */           if (!bhj_isNull240) {
/* 1086 */             agg_value38 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(bhj_value240.getBaseObject(), bhj_value240.getBaseOffset(), bhj_value240.numBytes(), agg_value38);
/* 1087 */           }
/* 1088 */
/* 1089 */           if (!bhj_isNull241) {
/* 1090 */             agg_value38 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(bhj_value241.getBaseObject(), bhj_value241.getBaseOffset(), bhj_value241.numBytes(), agg_value38);
/* 1091 */           }
/* 1092 */
/* 1093 */           if (!bhj_isNull3) {
/* 1094 */             agg_value38 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(bhj_value3, agg_value38);
/* 1095 */           }
/* 1096 */
/* 1097 */           if (!bhj_isNull65) {
/* 1098 */             agg_value38 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(bhj_value65, agg_value38);
/* 1099 */           }
/* 1100 */
/* 1101 */           if (!bhj_isNull87) {
/* 1102 */             agg_value38 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(bhj_value87, agg_value38);
/* 1103 */           }
/* 1104 */           if (true) {
/* 1105 */             // try to get the buffer from hash map
/* 1106 */             agg_unsafeRowAggBuffer =
/* 1107 */             agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result15, agg_value38);
/* 1108 */           }
/* 1109 */           if (agg_unsafeRowAggBuffer == null) {
/* 1110 */             if (agg_sorter == null) {
/* 1111 */               agg_sorter = agg_hashMap.destructAndCreateExternalSorter();
/* 1112 */             } else {
/* 1113 */               agg_sorter.merge(agg_hashMap.destructAndCreateExternalSorter());
/* 1114 */             }
/* 1115 */
/* 1116 */             // the hash map had be spilled, it should have enough memory now,
/* 1117 */             // try  to allocate buffer again.
/* 1118 */             agg_unsafeRowAggBuffer =
/* 1119 */             agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result15, agg_value38);
/* 1120 */             if (agg_unsafeRowAggBuffer == null) {
/* 1121 */               // failed to allocate the first page
/* 1122 */               throw new OutOfMemoryError("No enough memory for aggregation");
/* 1123 */             }
/* 1124 */           }
/* 1125 */         }
/* 1126 */
/* 1127 */         if (agg_fastAggBuffer != null) {
/* 1128 */           // update fast row
/* 1129 */
/* 1130 */           // common sub-expressions
/* 1131 */           boolean agg_isNull76 = false;
/* 1132 */           double agg_value80 = -1.0;
/* 1133 */           if (!false) {
/* 1134 */             agg_value80 = (double) 0;
/* 1135 */           }
/* 1136 */           // evaluate aggregate function
/* 1137 */           boolean agg_isNull78 = false;
/* 1138 */
/* 1139 */           long agg_value83 = agg_fastAggBuffer.getLong(0);
/* 1140 */
/* 1141 */           long agg_value82 = -1L;
/* 1142 */           agg_value82 = agg_value83 + 1L;
/* 1143 */           boolean agg_isNull82 = true;
/* 1144 */           double agg_value86 = -1.0;
/* 1145 */
/* 1146 */           boolean agg_isNull84 = agg_fastAggBuffer.isNullAt(1);
/* 1147 */           double agg_value88 = agg_isNull84 ? -1.0 : (agg_fastAggBuffer.getDouble(1));
/* 1148 */           boolean agg_isNull83 = agg_isNull84;
/* 1149 */           double agg_value87 = agg_value88;
/* 1150 */           if (agg_isNull83) {
/* 1151 */             if (!agg_isNull76) {
/* 1152 */               agg_isNull83 = false;
/* 1153 */               agg_value87 = agg_value80;
/* 1154 */             }
/* 1155 */           }
/* 1156 */
/* 1157 */           boolean agg_isNull85 = smj_isNull9;
/* 1158 */           double agg_value89 = -1.0;
/* 1159 */           if (!smj_isNull9) {
/* 1160 */             agg_value89 = smj_value11;
/* 1161 */           }
/* 1162 */           if (!agg_isNull85) {
/* 1163 */             agg_isNull82 = false; // resultCode could change nullability.
/* 1164 */             agg_value86 = agg_value87 + agg_value89;
/* 1165 */
/* 1166 */           }
/* 1167 */           boolean agg_isNull81 = agg_isNull82;
/* 1168 */           double agg_value85 = agg_value86;
/* 1169 */           if (agg_isNull81) {
/* 1170 */             boolean agg_isNull87 = agg_fastAggBuffer.isNullAt(1);
/* 1171 */             double agg_value91 = agg_isNull87 ? -1.0 : (agg_fastAggBuffer.getDouble(1));
/* 1172 */             if (!agg_isNull87) {
/* 1173 */               agg_isNull81 = false;
/* 1174 */               agg_value85 = agg_value91;
/* 1175 */             }
/* 1176 */           }
/* 1177 */           boolean agg_isNull89 = true;
/* 1178 */           double agg_value93 = -1.0;
/* 1179 */
/* 1180 */           boolean agg_isNull91 = agg_fastAggBuffer.isNullAt(2);
/* 1181 */           double agg_value95 = agg_isNull91 ? -1.0 : (agg_fastAggBuffer.getDouble(2));
/* 1182 */           boolean agg_isNull90 = agg_isNull91;
/* 1183 */           double agg_value94 = agg_value95;
/* 1184 */           if (agg_isNull90) {
/* 1185 */             if (!agg_isNull76) {
/* 1186 */               agg_isNull90 = false;
/* 1187 */               agg_value94 = agg_value80;
/* 1188 */             }
/* 1189 */           }
/* 1190 */
/* 1191 */           boolean agg_isNull92 = smj_isNull10;
/* 1192 */           double agg_value96 = -1.0;
/* 1193 */           if (!smj_isNull10) {
/* 1194 */             agg_value96 = smj_value12;
/* 1195 */           }
/* 1196 */           if (!agg_isNull92) {
/* 1197 */             agg_isNull89 = false; // resultCode could change nullability.
/* 1198 */             agg_value93 = agg_value94 + agg_value96;
/* 1199 */
/* 1200 */           }
/* 1201 */           boolean agg_isNull88 = agg_isNull89;
/* 1202 */           double agg_value92 = agg_value93;
/* 1203 */           if (agg_isNull88) {
/* 1204 */             boolean agg_isNull94 = agg_fastAggBuffer.isNullAt(2);
/* 1205 */             double agg_value98 = agg_isNull94 ? -1.0 : (agg_fastAggBuffer.getDouble(2));
/* 1206 */             if (!agg_isNull94) {
/* 1207 */               agg_isNull88 = false;
/* 1208 */               agg_value92 = agg_value98;
/* 1209 */             }
/* 1210 */           }
/* 1211 */           boolean agg_isNull96 = true;
/* 1212 */           double agg_value100 = -1.0;
/* 1213 */
/* 1214 */           boolean agg_isNull98 = agg_fastAggBuffer.isNullAt(3);
/* 1215 */           double agg_value102 = agg_isNull98 ? -1.0 : (agg_fastAggBuffer.getDouble(3));
/* 1216 */           boolean agg_isNull97 = agg_isNull98;
/* 1217 */           double agg_value101 = agg_value102;
/* 1218 */           if (agg_isNull97) {
/* 1219 */             if (!agg_isNull76) {
/* 1220 */               agg_isNull97 = false;
/* 1221 */               agg_value101 = agg_value80;
/* 1222 */             }
/* 1223 */           }
/* 1224 */
/* 1225 */           boolean agg_isNull99 = smj_isNull11;
/* 1226 */           double agg_value103 = -1.0;
/* 1227 */           if (!smj_isNull11) {
/* 1228 */             agg_value103 = smj_value13;
/* 1229 */           }
/* 1230 */           if (!agg_isNull99) {
/* 1231 */             agg_isNull96 = false; // resultCode could change nullability.
/* 1232 */             agg_value100 = agg_value101 + agg_value103;
/* 1233 */
/* 1234 */           }
/* 1235 */           boolean agg_isNull95 = agg_isNull96;
/* 1236 */           double agg_value99 = agg_value100;
/* 1237 */           if (agg_isNull95) {
/* 1238 */             boolean agg_isNull101 = agg_fastAggBuffer.isNullAt(3);
/* 1239 */             double agg_value105 = agg_isNull101 ? -1.0 : (agg_fastAggBuffer.getDouble(3));
/* 1240 */             if (!agg_isNull101) {
/* 1241 */               agg_isNull95 = false;
/* 1242 */               agg_value99 = agg_value105;
/* 1243 */             }
/* 1244 */           }
/* 1245 */           // update fast row
/* 1246 */           agg_fastAggBuffer.setLong(0, agg_value82);
/* 1247 */
/* 1248 */           if (!agg_isNull81) {
/* 1249 */             agg_fastAggBuffer.setDouble(1, agg_value85);
/* 1250 */           } else {
/* 1251 */             agg_fastAggBuffer.setNullAt(1);
/* 1252 */           }
/* 1253 */
/* 1254 */           if (!agg_isNull88) {
/* 1255 */             agg_fastAggBuffer.setDouble(2, agg_value92);
/* 1256 */           } else {
/* 1257 */             agg_fastAggBuffer.setNullAt(2);
/* 1258 */           }
/* 1259 */
/* 1260 */           if (!agg_isNull95) {
/* 1261 */             agg_fastAggBuffer.setDouble(3, agg_value99);
/* 1262 */           } else {
/* 1263 */             agg_fastAggBuffer.setNullAt(3);
/* 1264 */           }
/* 1265 */
/* 1266 */         } else {
/* 1267 */           // update unsafe row
/* 1268 */
/* 1269 */           // common sub-expressions
/* 1270 */           boolean agg_isNull50 = false;
/* 1271 */           double agg_value54 = -1.0;
/* 1272 */           if (!false) {
/* 1273 */             agg_value54 = (double) 0;
/* 1274 */           }
/* 1275 */           // evaluate aggregate function
/* 1276 */           boolean agg_isNull52 = false;
/* 1277 */
/* 1278 */           long agg_value57 = agg_unsafeRowAggBuffer.getLong(0);
/* 1279 */
/* 1280 */           long agg_value56 = -1L;
/* 1281 */           agg_value56 = agg_value57 + 1L;
/* 1282 */           boolean agg_isNull56 = true;
/* 1283 */           double agg_value60 = -1.0;
/* 1284 */
/* 1285 */           boolean agg_isNull58 = agg_unsafeRowAggBuffer.isNullAt(1);
/* 1286 */           double agg_value62 = agg_isNull58 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(1));
/* 1287 */           boolean agg_isNull57 = agg_isNull58;
/* 1288 */           double agg_value61 = agg_value62;
/* 1289 */           if (agg_isNull57) {
/* 1290 */             if (!agg_isNull50) {
/* 1291 */               agg_isNull57 = false;
/* 1292 */               agg_value61 = agg_value54;
/* 1293 */             }
/* 1294 */           }
/* 1295 */
/* 1296 */           boolean agg_isNull59 = smj_isNull9;
/* 1297 */           double agg_value63 = -1.0;
/* 1298 */           if (!smj_isNull9) {
/* 1299 */             agg_value63 = smj_value11;
/* 1300 */           }
/* 1301 */           if (!agg_isNull59) {
/* 1302 */             agg_isNull56 = false; // resultCode could change nullability.
/* 1303 */             agg_value60 = agg_value61 + agg_value63;
/* 1304 */
/* 1305 */           }
/* 1306 */           boolean agg_isNull55 = agg_isNull56;
/* 1307 */           double agg_value59 = agg_value60;
/* 1308 */           if (agg_isNull55) {
/* 1309 */             boolean agg_isNull61 = agg_unsafeRowAggBuffer.isNullAt(1);
/* 1310 */             double agg_value65 = agg_isNull61 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(1));
/* 1311 */             if (!agg_isNull61) {
/* 1312 */               agg_isNull55 = false;
/* 1313 */               agg_value59 = agg_value65;
/* 1314 */             }
/* 1315 */           }
/* 1316 */           boolean agg_isNull63 = true;
/* 1317 */           double agg_value67 = -1.0;
/* 1318 */
/* 1319 */           boolean agg_isNull65 = agg_unsafeRowAggBuffer.isNullAt(2);
/* 1320 */           double agg_value69 = agg_isNull65 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(2));
/* 1321 */           boolean agg_isNull64 = agg_isNull65;
/* 1322 */           double agg_value68 = agg_value69;
/* 1323 */           if (agg_isNull64) {
/* 1324 */             if (!agg_isNull50) {
/* 1325 */               agg_isNull64 = false;
/* 1326 */               agg_value68 = agg_value54;
/* 1327 */             }
/* 1328 */           }
/* 1329 */
/* 1330 */           boolean agg_isNull66 = smj_isNull10;
/* 1331 */           double agg_value70 = -1.0;
/* 1332 */           if (!smj_isNull10) {
/* 1333 */             agg_value70 = smj_value12;
/* 1334 */           }
/* 1335 */           if (!agg_isNull66) {
/* 1336 */             agg_isNull63 = false; // resultCode could change nullability.
/* 1337 */             agg_value67 = agg_value68 + agg_value70;
/* 1338 */
/* 1339 */           }
/* 1340 */           boolean agg_isNull62 = agg_isNull63;
/* 1341 */           double agg_value66 = agg_value67;
/* 1342 */           if (agg_isNull62) {
/* 1343 */             boolean agg_isNull68 = agg_unsafeRowAggBuffer.isNullAt(2);
/* 1344 */             double agg_value72 = agg_isNull68 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(2));
/* 1345 */             if (!agg_isNull68) {
/* 1346 */               agg_isNull62 = false;
/* 1347 */               agg_value66 = agg_value72;
/* 1348 */             }
/* 1349 */           }
/* 1350 */           boolean agg_isNull70 = true;
/* 1351 */           double agg_value74 = -1.0;
/* 1352 */
/* 1353 */           boolean agg_isNull72 = agg_unsafeRowAggBuffer.isNullAt(3);
/* 1354 */           double agg_value76 = agg_isNull72 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(3));
/* 1355 */           boolean agg_isNull71 = agg_isNull72;
/* 1356 */           double agg_value75 = agg_value76;
/* 1357 */           if (agg_isNull71) {
/* 1358 */             if (!agg_isNull50) {
/* 1359 */               agg_isNull71 = false;
/* 1360 */               agg_value75 = agg_value54;
/* 1361 */             }
/* 1362 */           }
/* 1363 */
/* 1364 */           boolean agg_isNull73 = smj_isNull11;
/* 1365 */           double agg_value77 = -1.0;
/* 1366 */           if (!smj_isNull11) {
/* 1367 */             agg_value77 = smj_value13;
/* 1368 */           }
/* 1369 */           if (!agg_isNull73) {
/* 1370 */             agg_isNull70 = false; // resultCode could change nullability.
/* 1371 */             agg_value74 = agg_value75 + agg_value77;
/* 1372 */
/* 1373 */           }
/* 1374 */           boolean agg_isNull69 = agg_isNull70;
/* 1375 */           double agg_value73 = agg_value74;
/* 1376 */           if (agg_isNull69) {
/* 1377 */             boolean agg_isNull75 = agg_unsafeRowAggBuffer.isNullAt(3);
/* 1378 */             double agg_value79 = agg_isNull75 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(3));
/* 1379 */             if (!agg_isNull75) {
/* 1380 */               agg_isNull69 = false;
/* 1381 */               agg_value73 = agg_value79;
/* 1382 */             }
/* 1383 */           }
/* 1384 */           // update unsafe row buffer
/* 1385 */           agg_unsafeRowAggBuffer.setLong(0, agg_value56);
/* 1386 */
/* 1387 */           if (!agg_isNull55) {
/* 1388 */             agg_unsafeRowAggBuffer.setDouble(1, agg_value59);
/* 1389 */           } else {
/* 1390 */             agg_unsafeRowAggBuffer.setNullAt(1);
/* 1391 */           }
/* 1392 */
/* 1393 */           if (!agg_isNull62) {
/* 1394 */             agg_unsafeRowAggBuffer.setDouble(2, agg_value66);
/* 1395 */           } else {
/* 1396 */             agg_unsafeRowAggBuffer.setNullAt(2);
/* 1397 */           }
/* 1398 */
/* 1399 */           if (!agg_isNull69) {
/* 1400 */             agg_unsafeRowAggBuffer.setDouble(3, agg_value73);
/* 1401 */           } else {
/* 1402 */             agg_unsafeRowAggBuffer.setNullAt(3);
/* 1403 */           }
/* 1404 */
/* 1405 */         }
/* 1406 */
/* 1407 */       }
/* 1408 */       if (shouldStop()) return;
/* 1409 */     }
/* 1410 */
/* 1411 */     agg_fastHashMapIter = agg_fastHashMap.rowIterator();
/* 1412 */
/* 1413 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 1414 */   }
/* 1415 */
/* 1416 */   private void wholestagecodegen_init_5() {
/* 1417 */     this.project_rowWriter5 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder5, 16);
/* 1418 */     this.bhj_broadcast5 = (org.apache.spark.broadcast.TorrentBroadcast) references[14];
/* 1419 */
/* 1420 */     bhj_relation5 = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast5.value()).asReadOnlyCopy();
/* 1421 */     incPeakExecutionMemory(bhj_relation5.estimatedSize());
/* 1422 */
/* 1423 */     this.bhj_numOutputRows5 = (org.apache.spark.sql.execution.metric.SQLMetric) references[15];
/* 1424 */     bhj_result5 = new UnsafeRow(18);
/* 1425 */     this.bhj_holder5 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result5, 96);
/* 1426 */     this.bhj_rowWriter5 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder5, 18);
/* 1427 */     project_result6 = new UnsafeRow(16);
/* 1428 */     this.project_holder6 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result6, 96);
/* 1429 */     this.project_rowWriter6 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder6, 16);
/* 1430 */     this.bhj_broadcast6 = (org.apache.spark.broadcast.TorrentBroadcast) references[16];
/* 1431 */
/* 1432 */   }
/* 1433 */
/* 1434 */   private void wholestagecodegen_init_8() {
/* 1435 */     this.bhj_rowWriter8 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder8, 15);
/* 1436 */     project_result9 = new UnsafeRow(13);
/* 1437 */     this.project_holder9 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result9, 64);
/* 1438 */     this.project_rowWriter9 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder9, 13);
/* 1439 */     this.bhj_broadcast9 = (org.apache.spark.broadcast.TorrentBroadcast) references[22];
/* 1440 */
/* 1441 */     bhj_relation9 = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast9.value()).asReadOnlyCopy();
/* 1442 */     incPeakExecutionMemory(bhj_relation9.estimatedSize());
/* 1443 */
/* 1444 */     this.bhj_numOutputRows9 = (org.apache.spark.sql.execution.metric.SQLMetric) references[23];
/* 1445 */     bhj_result9 = new UnsafeRow(15);
/* 1446 */     this.bhj_holder9 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result9, 64);
/* 1447 */     this.bhj_rowWriter9 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder9, 15);
/* 1448 */     project_result10 = new UnsafeRow(13);
/* 1449 */     this.project_holder10 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result10, 64);
/* 1450 */
/* 1451 */   }
/* 1452 */
/* 1453 */   private void wholestagecodegen_init_2() {
/* 1454 */     bhj_relation1 = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast1.value()).asReadOnlyCopy();
/* 1455 */     incPeakExecutionMemory(bhj_relation1.estimatedSize());
/* 1456 */
/* 1457 */     this.bhj_numOutputRows1 = (org.apache.spark.sql.execution.metric.SQLMetric) references[7];
/* 1458 */     bhj_result1 = new UnsafeRow(14);
/* 1459 */     this.bhj_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result1, 64);
/* 1460 */     this.bhj_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder1, 14);
/* 1461 */     project_result2 = new UnsafeRow(12);
/* 1462 */     this.project_holder2 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result2, 64);
/* 1463 */     this.project_rowWriter2 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder2, 12);
/* 1464 */     this.bhj_broadcast2 = (org.apache.spark.broadcast.TorrentBroadcast) references[8];
/* 1465 */
/* 1466 */     bhj_relation2 = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast2.value()).asReadOnlyCopy();
/* 1467 */     incPeakExecutionMemory(bhj_relation2.estimatedSize());
/* 1468 */
/* 1469 */   }
/* 1470 */
/* 1471 */   private void wholestagecodegen_init_11() {
/* 1472 */     this.bhj_numOutputRows12 = (org.apache.spark.sql.execution.metric.SQLMetric) references[29];
/* 1473 */     bhj_result12 = new UnsafeRow(20);
/* 1474 */     this.bhj_holder12 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result12, 320);
/* 1475 */     this.bhj_rowWriter12 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder12, 20);
/* 1476 */     project_result13 = new UnsafeRow(18);
/* 1477 */     this.project_holder13 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result13, 320);
/* 1478 */     this.project_rowWriter13 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder13, 18);
/* 1479 */     this.bhj_broadcast13 = (org.apache.spark.broadcast.TorrentBroadcast) references[30];
/* 1480 */
/* 1481 */     bhj_relation13 = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast13.value()).asReadOnlyCopy();
/* 1482 */     incPeakExecutionMemory(bhj_relation13.estimatedSize());
/* 1483 */
/* 1484 */     this.bhj_numOutputRows13 = (org.apache.spark.sql.execution.metric.SQLMetric) references[31];
/* 1485 */     bhj_result13 = new UnsafeRow(19);
/* 1486 */     this.bhj_holder13 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result13, 320);
/* 1487 */
/* 1488 */   }
/* 1489 */
/* 1490 */   private void wholestagecodegen_init_1() {
/* 1491 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 11);
/* 1492 */     this.bhj_broadcast = (org.apache.spark.broadcast.TorrentBroadcast) references[4];
/* 1493 */
/* 1494 */     bhj_relation = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast.value()).asReadOnlyCopy();
/* 1495 */     incPeakExecutionMemory(bhj_relation.estimatedSize());
/* 1496 */
/* 1497 */     this.bhj_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[5];
/* 1498 */     bhj_result = new UnsafeRow(13);
/* 1499 */     this.bhj_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result, 0);
/* 1500 */     this.bhj_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder, 13);
/* 1501 */     project_result1 = new UnsafeRow(11);
/* 1502 */     this.project_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result1, 0);
/* 1503 */     this.project_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder1, 11);
/* 1504 */     this.bhj_broadcast1 = (org.apache.spark.broadcast.TorrentBroadcast) references[6];
/* 1505 */
/* 1506 */   }
/* 1507 */
/* 1508 */   private void wholestagecodegen_init_4() {
/* 1509 */     this.bhj_rowWriter3 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder3, 18);
/* 1510 */     project_result4 = new UnsafeRow(16);
/* 1511 */     this.project_holder4 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result4, 64);
/* 1512 */     this.project_rowWriter4 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder4, 16);
/* 1513 */     this.bhj_broadcast4 = (org.apache.spark.broadcast.TorrentBroadcast) references[12];
/* 1514 */
/* 1515 */     bhj_relation4 = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast4.value()).asReadOnlyCopy();
/* 1516 */     incPeakExecutionMemory(bhj_relation4.estimatedSize());
/* 1517 */
/* 1518 */     this.bhj_numOutputRows4 = (org.apache.spark.sql.execution.metric.SQLMetric) references[13];
/* 1519 */     bhj_result4 = new UnsafeRow(18);
/* 1520 */     this.bhj_holder4 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result4, 64);
/* 1521 */     this.bhj_rowWriter4 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder4, 18);
/* 1522 */     project_result5 = new UnsafeRow(16);
/* 1523 */     this.project_holder5 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result5, 64);
/* 1524 */
/* 1525 */   }
/* 1526 */
/* 1527 */   private void wholestagecodegen_init_7() {
/* 1528 */     this.bhj_numOutputRows7 = (org.apache.spark.sql.execution.metric.SQLMetric) references[19];
/* 1529 */     bhj_result7 = new UnsafeRow(15);
/* 1530 */     this.bhj_holder7 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result7, 64);
/* 1531 */     this.bhj_rowWriter7 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder7, 15);
/* 1532 */     project_result8 = new UnsafeRow(13);
/* 1533 */     this.project_holder8 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result8, 64);
/* 1534 */     this.project_rowWriter8 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder8, 13);
/* 1535 */     this.bhj_broadcast8 = (org.apache.spark.broadcast.TorrentBroadcast) references[20];
/* 1536 */
/* 1537 */     bhj_relation8 = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast8.value()).asReadOnlyCopy();
/* 1538 */     incPeakExecutionMemory(bhj_relation8.estimatedSize());
/* 1539 */
/* 1540 */     this.bhj_numOutputRows8 = (org.apache.spark.sql.execution.metric.SQLMetric) references[21];
/* 1541 */     bhj_result8 = new UnsafeRow(15);
/* 1542 */     this.bhj_holder8 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result8, 64);
/* 1543 */
/* 1544 */   }
/* 1545 */
/* 1546 */   private void wholestagecodegen_init_13() {
/* 1547 */     this.project_holder15 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result15, 352);
/* 1548 */     this.project_rowWriter15 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder15, 18);
/* 1549 */     agg_result15 = new UnsafeRow(15);
/* 1550 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result15, 352);
/* 1551 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 15);
/* 1552 */
/* 1553 */     agg_unsafeRowJoiner = agg_plan.createUnsafeJoiner();
/* 1554 */     this.wholestagecodegen_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[34];
/* 1555 */     this.wholestagecodegen_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[35];
/* 1556 */
/* 1557 */   }
/* 1558 */
/* 1559 */   private void wholestagecodegen_init_6() {
/* 1560 */     bhj_relation6 = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast6.value()).asReadOnlyCopy();
/* 1561 */     incPeakExecutionMemory(bhj_relation6.estimatedSize());
/* 1562 */
/* 1563 */     this.bhj_numOutputRows6 = (org.apache.spark.sql.execution.metric.SQLMetric) references[17];
/* 1564 */     bhj_result6 = new UnsafeRow(18);
/* 1565 */     this.bhj_holder6 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result6, 128);
/* 1566 */     this.bhj_rowWriter6 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder6, 18);
/* 1567 */     project_result7 = new UnsafeRow(14);
/* 1568 */     this.project_holder7 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result7, 64);
/* 1569 */     this.project_rowWriter7 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder7, 14);
/* 1570 */     this.bhj_broadcast7 = (org.apache.spark.broadcast.TorrentBroadcast) references[18];
/* 1571 */
/* 1572 */     bhj_relation7 = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast7.value()).asReadOnlyCopy();
/* 1573 */     incPeakExecutionMemory(bhj_relation7.estimatedSize());
/* 1574 */
/* 1575 */   }
/* 1576 */
/* 1577 */   protected void processNext() throws java.io.IOException {
/* 1578 */     if (!agg_initAgg) {
/* 1579 */       agg_initAgg = true;
/* 1580 */       long wholestagecodegen_beforeAgg = System.nanoTime();
/* 1581 */       agg_doAggregateWithKeys();
/* 1582 */       wholestagecodegen_aggTime.add((System.nanoTime() - wholestagecodegen_beforeAgg) / 1000000);
/* 1583 */     }
/* 1584 */
/* 1585 */     // output the result
/* 1586 */
/* 1587 */     while (agg_fastHashMapIter.next()) {
/* 1588 */       wholestagecodegen_numOutputRows.add(1);
/* 1589 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_fastHashMapIter.getKey();
/* 1590 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_fastHashMapIter.getValue();
/* 1591 */
/* 1592 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey, agg_aggBuffer);
/* 1593 */
/* 1594 */       append(agg_resultRow.copy());
/* 1595 */
/* 1596 */       if (shouldStop()) return;
/* 1597 */     }
/* 1598 */     agg_fastHashMap.close();
/* 1599 */
/* 1600 */     while (agg_mapIter.next()) {
/* 1601 */       wholestagecodegen_numOutputRows.add(1);
/* 1602 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter.getKey();
/* 1603 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter.getValue();
/* 1604 */
/* 1605 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey, agg_aggBuffer);
/* 1606 */
/* 1607 */       append(agg_resultRow.copy());
/* 1608 */
/* 1609 */       if (shouldStop()) return;
/* 1610 */     }
/* 1611 */
/* 1612 */     agg_mapIter.close();
/* 1613 */     if (agg_sorter == null) {
/* 1614 */       agg_hashMap.free();
/* 1615 */     }
/* 1616 */   }
/* 1617 */ }
