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
/* 030 */   private org.apache.spark.sql.execution.ExternalAppendOnlyUnsafeRowArray smj_matches;
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
/* 044 */   private double smj_value10;
/* 045 */   private boolean smj_isNull8;
/* 046 */   private double smj_value11;
/* 047 */   private boolean smj_isNull9;
/* 048 */   private double smj_value12;
/* 049 */   private boolean smj_isNull10;
/* 050 */   private int smj_value13;
/* 051 */   private boolean smj_isNull11;
/* 052 */   private UTF8String smj_value14;
/* 053 */   private boolean smj_isNull12;
/* 054 */   private UTF8String smj_value15;
/* 055 */   private boolean smj_isNull13;
/* 056 */   private org.apache.spark.sql.execution.metric.SQLMetric smj_numOutputRows;
/* 057 */   private UnsafeRow smj_result;
/* 058 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder smj_holder;
/* 059 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter smj_rowWriter;
/* 060 */   private UnsafeRow project_result;
/* 061 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder;
/* 062 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter;
/* 063 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast;
/* 064 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation;
/* 065 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows;
/* 066 */   private UnsafeRow bhj_result;
/* 067 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder;
/* 068 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter;
/* 069 */   private UnsafeRow project_result1;
/* 070 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder1;
/* 071 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter1;
/* 072 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast1;
/* 073 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation1;
/* 074 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows1;
/* 075 */   private UnsafeRow bhj_result1;
/* 076 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder1;
/* 077 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter1;
/* 078 */   private UnsafeRow project_result2;
/* 079 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder2;
/* 080 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter2;
/* 081 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast2;
/* 082 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation2;
/* 083 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows2;
/* 084 */   private UnsafeRow bhj_result2;
/* 085 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder2;
/* 086 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter2;
/* 087 */   private UnsafeRow project_result3;
/* 088 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder3;
/* 089 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter3;
/* 090 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast3;
/* 091 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation3;
/* 092 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows3;
/* 093 */   private UnsafeRow bhj_result3;
/* 094 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder3;
/* 095 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter3;
/* 096 */   private UnsafeRow project_result4;
/* 097 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder4;
/* 098 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter4;
/* 099 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast4;
/* 100 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation4;
/* 101 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows4;
/* 102 */   private UnsafeRow bhj_result4;
/* 103 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder4;
/* 104 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter4;
/* 105 */   private UnsafeRow project_result5;
/* 106 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder5;
/* 107 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter5;
/* 108 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast5;
/* 109 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation5;
/* 110 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows5;
/* 111 */   private UnsafeRow bhj_result5;
/* 112 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder5;
/* 113 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter5;
/* 114 */   private UnsafeRow project_result6;
/* 115 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder6;
/* 116 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter6;
/* 117 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast6;
/* 118 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation6;
/* 119 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows6;
/* 120 */   private UnsafeRow bhj_result6;
/* 121 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder6;
/* 122 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter6;
/* 123 */   private UnsafeRow project_result7;
/* 124 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder7;
/* 125 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter7;
/* 126 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast7;
/* 127 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation7;
/* 128 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows7;
/* 129 */   private UnsafeRow bhj_result7;
/* 130 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder7;
/* 131 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter7;
/* 132 */   private UnsafeRow project_result8;
/* 133 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder8;
/* 134 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter8;
/* 135 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast8;
/* 136 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation8;
/* 137 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows8;
/* 138 */   private UnsafeRow bhj_result8;
/* 139 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder8;
/* 140 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter8;
/* 141 */   private UnsafeRow project_result9;
/* 142 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder9;
/* 143 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter9;
/* 144 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast9;
/* 145 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation9;
/* 146 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows9;
/* 147 */   private UnsafeRow bhj_result9;
/* 148 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder9;
/* 149 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter9;
/* 150 */   private UnsafeRow project_result10;
/* 151 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder10;
/* 152 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter10;
/* 153 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast10;
/* 154 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation10;
/* 155 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows10;
/* 156 */   private UnsafeRow bhj_result10;
/* 157 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder10;
/* 158 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter10;
/* 159 */   private UnsafeRow project_result11;
/* 160 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder11;
/* 161 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter11;
/* 162 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast11;
/* 163 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation11;
/* 164 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows11;
/* 165 */   private UnsafeRow bhj_result11;
/* 166 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder11;
/* 167 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter11;
/* 168 */   private UnsafeRow project_result12;
/* 169 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder12;
/* 170 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter12;
/* 171 */   private UnsafeRow agg_result15;
/* 172 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder;
/* 173 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter;
/* 174 */   private int agg_value38;
/* 175 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowJoiner agg_unsafeRowJoiner;
/* 176 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_numOutputRows;
/* 177 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_aggTime;
/* 178 */
/* 179 */   public GeneratedIterator(Object[] references) {
/* 180 */     this.references = references;
/* 181 */   }
/* 182 */
/* 183 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 184 */     partitionIndex = index;
/* 185 */     this.inputs = inputs;
/* 186 */     wholestagecodegen_init_0();
/* 187 */     wholestagecodegen_init_1();
/* 188 */     wholestagecodegen_init_2();
/* 189 */     wholestagecodegen_init_3();
/* 190 */     wholestagecodegen_init_4();
/* 191 */     wholestagecodegen_init_5();
/* 192 */     wholestagecodegen_init_6();
/* 193 */     wholestagecodegen_init_7();
/* 194 */     wholestagecodegen_init_8();
/* 195 */     wholestagecodegen_init_9();
/* 196 */     wholestagecodegen_init_10();
/* 197 */     wholestagecodegen_init_11();
/* 198 */
/* 199 */   }
/* 200 */
/* 201 */   private void wholestagecodegen_init_9() {
/* 202 */     this.project_rowWriter10 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder10, 18);
/* 203 */     this.bhj_broadcast10 = (org.apache.spark.broadcast.TorrentBroadcast) references[43];
/* 204 */
/* 205 */     bhj_relation10 = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast10.value()).asReadOnlyCopy();
/* 206 */     incPeakExecutionMemory(bhj_relation10.estimatedSize());
/* 207 */
/* 208 */     this.bhj_numOutputRows10 = (org.apache.spark.sql.execution.metric.SQLMetric) references[44];
/* 209 */     bhj_result10 = new UnsafeRow(19);
/* 210 */     this.bhj_holder10 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result10, 320);
/* 211 */     this.bhj_rowWriter10 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder10, 19);
/* 212 */     project_result11 = new UnsafeRow(17);
/* 213 */     this.project_holder11 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result11, 320);
/* 214 */     this.project_rowWriter11 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder11, 17);
/* 215 */     this.bhj_broadcast11 = (org.apache.spark.broadcast.TorrentBroadcast) references[45];
/* 216 */
/* 217 */   }
/* 218 */
/* 219 */   private void wholestagecodegen_init_0() {
/* 220 */     agg_initAgg = false;
/* 221 */
/* 222 */     this.agg_plan = (org.apache.spark.sql.execution.aggregate.HashAggregateExec) references[0];
/* 223 */     agg_fastHashMap = new agg_FastHashMap(agg_plan.getTaskMemoryManager(), agg_plan.getEmptyAggregationBuffer());
/* 224 */
/* 225 */     this.agg_peakMemory = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 226 */     this.agg_spillSize = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 227 */     smj_leftInput = inputs[0];
/* 228 */     smj_rightInput = inputs[1];
/* 229 */
/* 230 */     smj_rightRow = null;
/* 231 */
/* 232 */     smj_matches = new org.apache.spark.sql.execution.ExternalAppendOnlyUnsafeRowArray(2147483647);
/* 233 */
/* 234 */     this.smj_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[22];
/* 235 */     smj_result = new UnsafeRow(18);
/* 236 */     this.smj_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(smj_result, 64);
/* 237 */     this.smj_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(smj_holder, 18);
/* 238 */     project_result = new UnsafeRow(16);
/* 239 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 64);
/* 240 */
/* 241 */   }
/* 242 */
/* 243 */   private void wholestagecodegen_init_10() {
/* 244 */     bhj_relation11 = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast11.value()).asReadOnlyCopy();
/* 245 */     incPeakExecutionMemory(bhj_relation11.estimatedSize());
/* 246 */
/* 247 */     this.bhj_numOutputRows11 = (org.apache.spark.sql.execution.metric.SQLMetric) references[46];
/* 248 */     bhj_result11 = new UnsafeRow(19);
/* 249 */     this.bhj_holder11 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result11, 352);
/* 250 */     this.bhj_rowWriter11 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder11, 19);
/* 251 */     project_result12 = new UnsafeRow(18);
/* 252 */     this.project_holder12 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result12, 352);
/* 253 */     this.project_rowWriter12 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder12, 18);
/* 254 */     agg_result15 = new UnsafeRow(15);
/* 255 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result15, 352);
/* 256 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 15);
/* 257 */
/* 258 */   }
/* 259 */
/* 260 */   private void wholestagecodegen_init_3() {
/* 261 */     this.bhj_numOutputRows2 = (org.apache.spark.sql.execution.metric.SQLMetric) references[28];
/* 262 */     bhj_result2 = new UnsafeRow(18);
/* 263 */     this.bhj_holder2 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result2, 96);
/* 264 */     this.bhj_rowWriter2 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder2, 18);
/* 265 */     project_result3 = new UnsafeRow(16);
/* 266 */     this.project_holder3 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result3, 96);
/* 267 */     this.project_rowWriter3 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder3, 16);
/* 268 */     this.bhj_broadcast3 = (org.apache.spark.broadcast.TorrentBroadcast) references[29];
/* 269 */
/* 270 */     bhj_relation3 = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast3.value()).asReadOnlyCopy();
/* 271 */     incPeakExecutionMemory(bhj_relation3.estimatedSize());
/* 272 */
/* 273 */     this.bhj_numOutputRows3 = (org.apache.spark.sql.execution.metric.SQLMetric) references[30];
/* 274 */     bhj_result3 = new UnsafeRow(18);
/* 275 */     this.bhj_holder3 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result3, 128);
/* 276 */
/* 277 */   }
/* 278 */
/* 279 */   private boolean findNextInnerJoinRows(
/* 280 */     scala.collection.Iterator leftIter,
/* 281 */     scala.collection.Iterator rightIter) {
/* 282 */     smj_leftRow = null;
/* 283 */     int comp = 0;
/* 284 */     while (smj_leftRow == null) {
/* 285 */       if (!leftIter.hasNext()) return false;
/* 286 */       smj_leftRow = (InternalRow) leftIter.next();
/* 287 */
/* 288 */       boolean smj_isNull = smj_leftRow.isNullAt(1);
/* 289 */       int smj_value = smj_isNull ? -1 : (smj_leftRow.getInt(1));
/* 290 */       if (smj_isNull) {
/* 291 */         smj_leftRow = null;
/* 292 */         continue;
/* 293 */       }
/* 294 */       if (!smj_matches.isEmpty()) {
/* 295 */         comp = 0;
/* 296 */         if (comp == 0) {
/* 297 */           comp = (smj_value > smj_value3 ? 1 : smj_value < smj_value3 ? -1 : 0);
/* 298 */         }
/* 299 */
/* 300 */         if (comp == 0) {
/* 301 */           return true;
/* 302 */         }
/* 303 */         smj_matches.clear();
/* 304 */       }
/* 305 */
/* 306 */       do {
/* 307 */         if (smj_rightRow == null) {
/* 308 */           if (!rightIter.hasNext()) {
/* 309 */             smj_value3 = smj_value;
/* 310 */             return !smj_matches.isEmpty();
/* 311 */           }
/* 312 */           smj_rightRow = (InternalRow) rightIter.next();
/* 313 */
/* 314 */           boolean smj_isNull1 = smj_rightRow.isNullAt(0);
/* 315 */           int smj_value1 = smj_isNull1 ? -1 : (smj_rightRow.getInt(0));
/* 316 */           if (smj_isNull1) {
/* 317 */             smj_rightRow = null;
/* 318 */             continue;
/* 319 */           }
/* 320 */           smj_value2 = smj_value1;
/* 321 */         }
/* 322 */
/* 323 */         comp = 0;
/* 324 */         if (comp == 0) {
/* 325 */           comp = (smj_value > smj_value2 ? 1 : smj_value < smj_value2 ? -1 : 0);
/* 326 */         }
/* 327 */
/* 328 */         if (comp > 0) {
/* 329 */           smj_rightRow = null;
/* 330 */         } else if (comp < 0) {
/* 331 */           if (!smj_matches.isEmpty()) {
/* 332 */             smj_value3 = smj_value;
/* 333 */             return true;
/* 334 */           }
/* 335 */           smj_leftRow = null;
/* 336 */         } else {
/* 337 */           smj_matches.add((UnsafeRow) smj_rightRow);
/* 338 */           smj_rightRow = null;;
/* 339 */         }
/* 340 */       } while (smj_leftRow != null);
/* 341 */     }
/* 342 */     return false; // unreachable
/* 343 */   }
/* 344 */
/* 345 */   public class agg_FastHashMap {
/* 346 */     private org.apache.spark.sql.catalyst.expressions.RowBasedKeyValueBatch batch;
/* 347 */     private int[] buckets;
/* 348 */     private int capacity = 1 << 16;
/* 349 */     private double loadFactor = 0.5;
/* 350 */     private int numBuckets = (int) (capacity / loadFactor);
/* 351 */     private int maxSteps = 2;
/* 352 */     private int numRows = 0;
/* 353 */     private org.apache.spark.sql.types.StructType keySchema = new org.apache.spark.sql.types.StructType().add("((java.lang.String) references[3])", org.apache.spark.sql.types.DataTypes.StringType)
/* 354 */     .add("((java.lang.String) references[4])", org.apache.spark.sql.types.DataTypes.IntegerType)
/* 355 */     .add("((java.lang.String) references[5])", org.apache.spark.sql.types.DataTypes.StringType)
/* 356 */     .add("((java.lang.String) references[6])", org.apache.spark.sql.types.DataTypes.StringType)
/* 357 */     .add("((java.lang.String) references[7])", org.apache.spark.sql.types.DataTypes.StringType)
/* 358 */     .add("((java.lang.String) references[8])", org.apache.spark.sql.types.DataTypes.StringType)
/* 359 */     .add("((java.lang.String) references[9])", org.apache.spark.sql.types.DataTypes.StringType)
/* 360 */     .add("((java.lang.String) references[10])", org.apache.spark.sql.types.DataTypes.StringType)
/* 361 */     .add("((java.lang.String) references[11])", org.apache.spark.sql.types.DataTypes.StringType)
/* 362 */     .add("((java.lang.String) references[12])", org.apache.spark.sql.types.DataTypes.StringType)
/* 363 */     .add("((java.lang.String) references[13])", org.apache.spark.sql.types.DataTypes.StringType)
/* 364 */     .add("((java.lang.String) references[14])", org.apache.spark.sql.types.DataTypes.StringType)
/* 365 */     .add("((java.lang.String) references[15])", org.apache.spark.sql.types.DataTypes.IntegerType)
/* 366 */     .add("((java.lang.String) references[16])", org.apache.spark.sql.types.DataTypes.IntegerType)
/* 367 */     .add("((java.lang.String) references[17])", org.apache.spark.sql.types.DataTypes.IntegerType);
/* 368 */     private org.apache.spark.sql.types.StructType valueSchema = new org.apache.spark.sql.types.StructType().add("((java.lang.String) references[18])", org.apache.spark.sql.types.DataTypes.LongType)
/* 369 */     .add("((java.lang.String) references[19])", org.apache.spark.sql.types.DataTypes.DoubleType)
/* 370 */     .add("((java.lang.String) references[20])", org.apache.spark.sql.types.DataTypes.DoubleType)
/* 371 */     .add("((java.lang.String) references[21])", org.apache.spark.sql.types.DataTypes.DoubleType);
/* 372 */     private Object emptyVBase;
/* 373 */     private long emptyVOff;
/* 374 */     private int emptyVLen;
/* 375 */     private boolean isBatchFull = false;
/* 376 */
/* 377 */     public agg_FastHashMap(
/* 378 */       org.apache.spark.memory.TaskMemoryManager taskMemoryManager,
/* 379 */       InternalRow emptyAggregationBuffer) {
/* 380 */       batch = org.apache.spark.sql.catalyst.expressions.RowBasedKeyValueBatch
/* 381 */       .allocate(keySchema, valueSchema, taskMemoryManager, capacity);
/* 382 */
/* 383 */       final UnsafeProjection valueProjection = UnsafeProjection.create(valueSchema);
/* 384 */       final byte[] emptyBuffer = valueProjection.apply(emptyAggregationBuffer).getBytes();
/* 385 */
/* 386 */       emptyVBase = emptyBuffer;
/* 387 */       emptyVOff = Platform.BYTE_ARRAY_OFFSET;
/* 388 */       emptyVLen = emptyBuffer.length;
/* 389 */
/* 390 */       buckets = new int[numBuckets];
/* 391 */       java.util.Arrays.fill(buckets, -1);
/* 392 */     }
/* 393 */
/* 394 */     public org.apache.spark.sql.catalyst.expressions.UnsafeRow findOrInsert(UTF8String agg_key, int agg_key1, UTF8String agg_key2, UTF8String agg_key3, UTF8String agg_key4, UTF8String agg_key5, UTF8String agg_key6, UTF8String agg_key7, UTF8String agg_key8, UTF8String agg_key9, UTF8String agg_key10, UTF8String agg_key11, int agg_key12, int agg_key13, int agg_key14) {
/* 395 */       long h = hash(agg_key, agg_key1, agg_key2, agg_key3, agg_key4, agg_key5, agg_key6, agg_key7, agg_key8, agg_key9, agg_key10, agg_key11, agg_key12, agg_key13, agg_key14);
/* 396 */       int step = 0;
/* 397 */       int idx = (int) h & (numBuckets - 1);
/* 398 */       while (step < maxSteps) {
/* 399 */         // Return bucket index if it's either an empty slot or already contains the key
/* 400 */         if (buckets[idx] == -1) {
/* 401 */           if (numRows < capacity && !isBatchFull) {
/* 402 */             // creating the unsafe for new entry
/* 403 */             UnsafeRow agg_result = new UnsafeRow(15);
/* 404 */             org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder
/* 405 */             = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result,
/* 406 */               352);
/* 407 */             org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter
/* 408 */             = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(
/* 409 */               agg_holder,
/* 410 */               15);
/* 411 */             agg_holder.reset(); //TODO: investigate if reset or zeroout are actually needed
/* 412 */             agg_rowWriter.zeroOutNullBytes();
/* 413 */             agg_rowWriter.write(0, agg_key);
/* 414 */             agg_rowWriter.write(1, agg_key1);
/* 415 */             agg_rowWriter.write(2, agg_key2);
/* 416 */             agg_rowWriter.write(3, agg_key3);
/* 417 */             agg_rowWriter.write(4, agg_key4);
/* 418 */             agg_rowWriter.write(5, agg_key5);
/* 419 */             agg_rowWriter.write(6, agg_key6);
/* 420 */             agg_rowWriter.write(7, agg_key7);
/* 421 */             agg_rowWriter.write(8, agg_key8);
/* 422 */             agg_rowWriter.write(9, agg_key9);
/* 423 */             agg_rowWriter.write(10, agg_key10);
/* 424 */             agg_rowWriter.write(11, agg_key11);
/* 425 */             agg_rowWriter.write(12, agg_key12);
/* 426 */             agg_rowWriter.write(13, agg_key13);
/* 427 */             agg_rowWriter.write(14, agg_key14);
/* 428 */             agg_result.setTotalSize(agg_holder.totalSize());
/* 429 */             Object kbase = agg_result.getBaseObject();
/* 430 */             long koff = agg_result.getBaseOffset();
/* 431 */             int klen = agg_result.getSizeInBytes();
/* 432 */
/* 433 */             UnsafeRow vRow
/* 434 */             = batch.appendRow(kbase, koff, klen, emptyVBase, emptyVOff, emptyVLen);
/* 435 */             if (vRow == null) {
/* 436 */               isBatchFull = true;
/* 437 */             } else {
/* 438 */               buckets[idx] = numRows++;
/* 439 */             }
/* 440 */             return vRow;
/* 441 */           } else {
/* 442 */             // No more space
/* 443 */             return null;
/* 444 */           }
/* 445 */         } else if (equals(idx, agg_key, agg_key1, agg_key2, agg_key3, agg_key4, agg_key5, agg_key6, agg_key7, agg_key8, agg_key9, agg_key10, agg_key11, agg_key12, agg_key13, agg_key14)) {
/* 446 */           return batch.getValueRow(buckets[idx]);
/* 447 */         }
/* 448 */         idx = (idx + 1) & (numBuckets - 1);
/* 449 */         step++;
/* 450 */       }
/* 451 */       // Didn't find it
/* 452 */       return null;
/* 453 */     }
/* 454 */
/* 455 */     private boolean equals(int idx, UTF8String agg_key, int agg_key1, UTF8String agg_key2, UTF8String agg_key3, UTF8String agg_key4, UTF8String agg_key5, UTF8String agg_key6, UTF8String agg_key7, UTF8String agg_key8, UTF8String agg_key9, UTF8String agg_key10, UTF8String agg_key11, int agg_key12, int agg_key13, int agg_key14) {
/* 456 */       UnsafeRow row = batch.getKeyRow(buckets[idx]);
/* 457 */       return (row.getUTF8String(0).equals(agg_key)) && (row.getInt(1) == agg_key1) && (row.getUTF8String(2).equals(agg_key2)) && (row.getUTF8String(3).equals(agg_key3)) && (row.getUTF8String(4).equals(agg_key4)) && (row.getUTF8String(5).equals(agg_key5)) && (row.getUTF8String(6).equals(agg_key6)) && (row.getUTF8String(7).equals(agg_key7)) && (row.getUTF8String(8).equals(agg_key8)) && (row.getUTF8String(9).equals(agg_key9)) && (row.getUTF8String(10).equals(agg_key10)) && (row.getUTF8String(11).equals(agg_key11)) && (row.getInt(12) == agg_key12) && (row.getInt(13) == agg_key13) && (row.getInt(14) == agg_key14);
/* 458 */     }
/* 459 */
/* 460 */     private long hash(UTF8String agg_key, int agg_key1, UTF8String agg_key2, UTF8String agg_key3, UTF8String agg_key4, UTF8String agg_key5, UTF8String agg_key6, UTF8String agg_key7, UTF8String agg_key8, UTF8String agg_key9, UTF8String agg_key10, UTF8String agg_key11, int agg_key12, int agg_key13, int agg_key14) {
/* 461 */       long agg_hash = 0;
/* 462 */
/* 463 */       int agg_result = 0;
/* 464 */       byte[] agg_bytes = agg_key.getBytes();
/* 465 */       for (int i = 0; i < agg_bytes.length; i++) {
/* 466 */         int agg_hash1 = agg_bytes[i];
/* 467 */         agg_result = (agg_result ^ (0x9e3779b9)) + agg_hash1 + (agg_result << 6) + (agg_result >>> 2);
/* 468 */       }
/* 469 */
/* 470 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result + (agg_hash << 6) + (agg_hash >>> 2);
/* 471 */
/* 472 */       int agg_result1 = agg_key1;
/* 473 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result1 + (agg_hash << 6) + (agg_hash >>> 2);
/* 474 */
/* 475 */       int agg_result2 = 0;
/* 476 */       byte[] agg_bytes1 = agg_key2.getBytes();
/* 477 */       for (int i = 0; i < agg_bytes1.length; i++) {
/* 478 */         int agg_hash2 = agg_bytes1[i];
/* 479 */         agg_result2 = (agg_result2 ^ (0x9e3779b9)) + agg_hash2 + (agg_result2 << 6) + (agg_result2 >>> 2);
/* 480 */       }
/* 481 */
/* 482 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result2 + (agg_hash << 6) + (agg_hash >>> 2);
/* 483 */
/* 484 */       int agg_result3 = 0;
/* 485 */       byte[] agg_bytes2 = agg_key3.getBytes();
/* 486 */       for (int i = 0; i < agg_bytes2.length; i++) {
/* 487 */         int agg_hash3 = agg_bytes2[i];
/* 488 */         agg_result3 = (agg_result3 ^ (0x9e3779b9)) + agg_hash3 + (agg_result3 << 6) + (agg_result3 >>> 2);
/* 489 */       }
/* 490 */
/* 491 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result3 + (agg_hash << 6) + (agg_hash >>> 2);
/* 492 */
/* 493 */       int agg_result4 = 0;
/* 494 */       byte[] agg_bytes3 = agg_key4.getBytes();
/* 495 */       for (int i = 0; i < agg_bytes3.length; i++) {
/* 496 */         int agg_hash4 = agg_bytes3[i];
/* 497 */         agg_result4 = (agg_result4 ^ (0x9e3779b9)) + agg_hash4 + (agg_result4 << 6) + (agg_result4 >>> 2);
/* 498 */       }
/* 499 */
/* 500 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result4 + (agg_hash << 6) + (agg_hash >>> 2);
/* 501 */
/* 502 */       int agg_result5 = 0;
/* 503 */       byte[] agg_bytes4 = agg_key5.getBytes();
/* 504 */       for (int i = 0; i < agg_bytes4.length; i++) {
/* 505 */         int agg_hash5 = agg_bytes4[i];
/* 506 */         agg_result5 = (agg_result5 ^ (0x9e3779b9)) + agg_hash5 + (agg_result5 << 6) + (agg_result5 >>> 2);
/* 507 */       }
/* 508 */
/* 509 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result5 + (agg_hash << 6) + (agg_hash >>> 2);
/* 510 */
/* 511 */       int agg_result6 = 0;
/* 512 */       byte[] agg_bytes5 = agg_key6.getBytes();
/* 513 */       for (int i = 0; i < agg_bytes5.length; i++) {
/* 514 */         int agg_hash6 = agg_bytes5[i];
/* 515 */         agg_result6 = (agg_result6 ^ (0x9e3779b9)) + agg_hash6 + (agg_result6 << 6) + (agg_result6 >>> 2);
/* 516 */       }
/* 517 */
/* 518 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result6 + (agg_hash << 6) + (agg_hash >>> 2);
/* 519 */
/* 520 */       int agg_result7 = 0;
/* 521 */       byte[] agg_bytes6 = agg_key7.getBytes();
/* 522 */       for (int i = 0; i < agg_bytes6.length; i++) {
/* 523 */         int agg_hash7 = agg_bytes6[i];
/* 524 */         agg_result7 = (agg_result7 ^ (0x9e3779b9)) + agg_hash7 + (agg_result7 << 6) + (agg_result7 >>> 2);
/* 525 */       }
/* 526 */
/* 527 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result7 + (agg_hash << 6) + (agg_hash >>> 2);
/* 528 */
/* 529 */       int agg_result8 = 0;
/* 530 */       byte[] agg_bytes7 = agg_key8.getBytes();
/* 531 */       for (int i = 0; i < agg_bytes7.length; i++) {
/* 532 */         int agg_hash8 = agg_bytes7[i];
/* 533 */         agg_result8 = (agg_result8 ^ (0x9e3779b9)) + agg_hash8 + (agg_result8 << 6) + (agg_result8 >>> 2);
/* 534 */       }
/* 535 */
/* 536 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result8 + (agg_hash << 6) + (agg_hash >>> 2);
/* 537 */
/* 538 */       int agg_result9 = 0;
/* 539 */       byte[] agg_bytes8 = agg_key9.getBytes();
/* 540 */       for (int i = 0; i < agg_bytes8.length; i++) {
/* 541 */         int agg_hash9 = agg_bytes8[i];
/* 542 */         agg_result9 = (agg_result9 ^ (0x9e3779b9)) + agg_hash9 + (agg_result9 << 6) + (agg_result9 >>> 2);
/* 543 */       }
/* 544 */
/* 545 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result9 + (agg_hash << 6) + (agg_hash >>> 2);
/* 546 */
/* 547 */       int agg_result10 = 0;
/* 548 */       byte[] agg_bytes9 = agg_key10.getBytes();
/* 549 */       for (int i = 0; i < agg_bytes9.length; i++) {
/* 550 */         int agg_hash10 = agg_bytes9[i];
/* 551 */         agg_result10 = (agg_result10 ^ (0x9e3779b9)) + agg_hash10 + (agg_result10 << 6) + (agg_result10 >>> 2);
/* 552 */       }
/* 553 */
/* 554 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result10 + (agg_hash << 6) + (agg_hash >>> 2);
/* 555 */
/* 556 */       int agg_result11 = 0;
/* 557 */       byte[] agg_bytes10 = agg_key11.getBytes();
/* 558 */       for (int i = 0; i < agg_bytes10.length; i++) {
/* 559 */         int agg_hash11 = agg_bytes10[i];
/* 560 */         agg_result11 = (agg_result11 ^ (0x9e3779b9)) + agg_hash11 + (agg_result11 << 6) + (agg_result11 >>> 2);
/* 561 */       }
/* 562 */
/* 563 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result11 + (agg_hash << 6) + (agg_hash >>> 2);
/* 564 */
/* 565 */       int agg_result12 = agg_key12;
/* 566 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result12 + (agg_hash << 6) + (agg_hash >>> 2);
/* 567 */
/* 568 */       int agg_result13 = agg_key13;
/* 569 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result13 + (agg_hash << 6) + (agg_hash >>> 2);
/* 570 */
/* 571 */       int agg_result14 = agg_key14;
/* 572 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result14 + (agg_hash << 6) + (agg_hash >>> 2);
/* 573 */
/* 574 */       return agg_hash;
/* 575 */     }
/* 576 */
/* 577 */     public org.apache.spark.unsafe.KVIterator<UnsafeRow, UnsafeRow> rowIterator() {
/* 578 */       return batch.rowIterator();
/* 579 */     }
/* 580 */
/* 581 */     public void close() {
/* 582 */       batch.close();
/* 583 */     }
/* 584 */
/* 585 */   }
/* 586 */
/* 587 */   private void agg_doAggregateWithKeys() throws java.io.IOException {
/* 588 */     agg_hashMap = agg_plan.createHashMap();
/* 589 */
/* 590 */     while (findNextInnerJoinRows(smj_leftInput, smj_rightInput)) {
/* 591 */       smj_isNull2 = smj_leftRow.isNullAt(0);
/* 592 */       smj_value4 = smj_isNull2 ? -1 : (smj_leftRow.getInt(0));
/* 593 */       smj_isNull3 = smj_leftRow.isNullAt(1);
/* 594 */       smj_value5 = smj_isNull3 ? -1 : (smj_leftRow.getInt(1));
/* 595 */       smj_isNull4 = smj_leftRow.isNullAt(2);
/* 596 */       smj_value6 = smj_isNull4 ? -1 : (smj_leftRow.getInt(2));
/* 597 */       smj_isNull5 = smj_leftRow.isNullAt(3);
/* 598 */       smj_value7 = smj_isNull5 ? -1 : (smj_leftRow.getInt(3));
/* 599 */       smj_isNull6 = smj_leftRow.isNullAt(4);
/* 600 */       smj_value8 = smj_isNull6 ? -1 : (smj_leftRow.getInt(4));
/* 601 */       smj_isNull7 = smj_leftRow.isNullAt(5);
/* 602 */       smj_value9 = smj_isNull7 ? -1 : (smj_leftRow.getInt(5));
/* 603 */       smj_isNull8 = smj_leftRow.isNullAt(6);
/* 604 */       smj_value10 = smj_isNull8 ? -1.0 : (smj_leftRow.getDouble(6));
/* 605 */       smj_isNull9 = smj_leftRow.isNullAt(7);
/* 606 */       smj_value11 = smj_isNull9 ? -1.0 : (smj_leftRow.getDouble(7));
/* 607 */       smj_isNull10 = smj_leftRow.isNullAt(8);
/* 608 */       smj_value12 = smj_isNull10 ? -1.0 : (smj_leftRow.getDouble(8));
/* 609 */       smj_isNull11 = smj_leftRow.isNullAt(9);
/* 610 */       smj_value13 = smj_isNull11 ? -1 : (smj_leftRow.getInt(9));
/* 611 */       smj_isNull12 = smj_leftRow.isNullAt(10);
/* 612 */       smj_value14 = smj_isNull12 ? null : (smj_leftRow.getUTF8String(10));
/* 613 */       smj_isNull13 = smj_leftRow.isNullAt(11);
/* 614 */       smj_value15 = smj_isNull13 ? null : (smj_leftRow.getUTF8String(11));
/* 615 */       scala.collection.Iterator<UnsafeRow> smj_iterator = smj_matches.generateIterator();
/* 616 */       while (smj_iterator.hasNext()) {
/* 617 */         InternalRow smj_rightRow1 = (InternalRow) smj_iterator.next();
/* 618 */
/* 619 */         smj_numOutputRows.add(1);
/* 620 */
/* 621 */         boolean smj_isNull19 = smj_rightRow1.isNullAt(5);
/* 622 */         int smj_value21 = smj_isNull19 ? -1 : (smj_rightRow1.getInt(5));
/* 623 */
/* 624 */         // generate join key for stream side
/* 625 */
/* 626 */         boolean bhj_isNull = smj_isNull19;
/* 627 */         long bhj_value = -1L;
/* 628 */         if (!smj_isNull19) {
/* 629 */           bhj_value = (long) smj_value21;
/* 630 */         }
/* 631 */         // find matches from HashedRelation
/* 632 */         UnsafeRow bhj_matched = bhj_isNull ? null: (UnsafeRow)bhj_relation.getValue(bhj_value);
/* 633 */         if (bhj_matched == null) continue;
/* 634 */
/* 635 */         bhj_numOutputRows.add(1);
/* 636 */
/* 637 */         boolean smj_isNull18 = smj_rightRow1.isNullAt(4);
/* 638 */         int smj_value20 = smj_isNull18 ? -1 : (smj_rightRow1.getInt(4));
/* 639 */
/* 640 */         // generate join key for stream side
/* 641 */
/* 642 */         boolean bhj_isNull22 = smj_isNull18;
/* 643 */         long bhj_value22 = -1L;
/* 644 */         if (!smj_isNull18) {
/* 645 */           bhj_value22 = (long) smj_value20;
/* 646 */         }
/* 647 */         // find matches from HashedRelation
/* 648 */         UnsafeRow bhj_matched1 = bhj_isNull22 ? null: (UnsafeRow)bhj_relation1.getValue(bhj_value22);
/* 649 */         if (bhj_matched1 == null) continue;
/* 650 */
/* 651 */         bhj_numOutputRows1.add(1);
/* 652 */
/* 653 */         // generate join key for stream side
/* 654 */
/* 655 */         boolean bhj_isNull44 = smj_isNull4;
/* 656 */         long bhj_value44 = -1L;
/* 657 */         if (!smj_isNull4) {
/* 658 */           bhj_value44 = (long) smj_value6;
/* 659 */         }
/* 660 */         // find matches from HashedRelation
/* 661 */         UnsafeRow bhj_matched2 = bhj_isNull44 ? null: (UnsafeRow)bhj_relation2.getValue(bhj_value44);
/* 662 */         if (bhj_matched2 == null) continue;
/* 663 */
/* 664 */         bhj_numOutputRows2.add(1);
/* 665 */
/* 666 */         boolean smj_isNull15 = smj_rightRow1.isNullAt(1);
/* 667 */         int smj_value17 = smj_isNull15 ? -1 : (smj_rightRow1.getInt(1));
/* 668 */         boolean bhj_isNull47 = bhj_matched2.isNullAt(1);
/* 669 */         UTF8String bhj_value47 = bhj_isNull47 ? null : (bhj_matched2.getUTF8String(1));
/* 670 */
/* 671 */         // generate join key for stream side
/* 672 */
/* 673 */         boolean bhj_isNull66 = smj_isNull15;
/* 674 */         long bhj_value66 = -1L;
/* 675 */         if (!smj_isNull15) {
/* 676 */           bhj_value66 = (long) smj_value17;
/* 677 */         }
/* 678 */         // find matches from HashedRelation
/* 679 */         UnsafeRow bhj_matched3 = bhj_isNull66 ? null: (UnsafeRow)bhj_relation3.getValue(bhj_value66);
/* 680 */         if (bhj_matched3 == null) continue;
/* 681 */
/* 682 */         boolean bhj_isNull69 = bhj_matched3.isNullAt(1);
/* 683 */         UTF8String bhj_value69 = bhj_isNull69 ? null : (bhj_matched3.getUTF8String(1));
/* 684 */
/* 685 */         boolean bhj_isNull71 = true;
/* 686 */         boolean bhj_value71 = false;
/* 687 */
/* 688 */         if (!bhj_isNull47) {
/* 689 */           if (!bhj_isNull69) {
/* 690 */             bhj_isNull71 = false; // resultCode could change nullability.
/* 691 */             bhj_value71 = bhj_value47.equals(bhj_value69);
/* 692 */
/* 693 */           }
/* 694 */
/* 695 */         }
/* 696 */         boolean bhj_isNull70 = bhj_isNull71;
/* 697 */         boolean bhj_value70 = false;
/* 698 */
/* 699 */         if (!bhj_isNull71) {
/* 700 */           bhj_value70 = !(bhj_value71);
/* 701 */         }
/* 702 */         if (bhj_isNull70 || !bhj_value70) continue;
/* 703 */
/* 704 */         bhj_numOutputRows3.add(1);
/* 705 */
/* 706 */         // generate join key for stream side
/* 707 */
/* 708 */         boolean bhj_isNull92 = smj_isNull7;
/* 709 */         long bhj_value92 = -1L;
/* 710 */         if (!smj_isNull7) {
/* 711 */           bhj_value92 = (long) smj_value9;
/* 712 */         }
/* 713 */         // find matches from HashedRelation
/* 714 */         UnsafeRow bhj_matched4 = bhj_isNull92 ? null: (UnsafeRow)bhj_relation4.getValue(bhj_value92);
/* 715 */         if (bhj_matched4 == null) continue;
/* 716 */
/* 717 */         bhj_numOutputRows4.add(1);
/* 718 */
/* 719 */         // generate join key for stream side
/* 720 */
/* 721 */         boolean bhj_isNull110 = smj_isNull5;
/* 722 */         long bhj_value110 = -1L;
/* 723 */         if (!smj_isNull5) {
/* 724 */           bhj_value110 = (long) smj_value7;
/* 725 */         }
/* 726 */         // find matches from HashedRelation
/* 727 */         UnsafeRow bhj_matched5 = bhj_isNull110 ? null: (UnsafeRow)bhj_relation5.getValue(bhj_value110);
/* 728 */         if (bhj_matched5 == null) continue;
/* 729 */
/* 730 */         bhj_numOutputRows5.add(1);
/* 731 */
/* 732 */         boolean smj_isNull16 = smj_rightRow1.isNullAt(2);
/* 733 */         int smj_value18 = smj_isNull16 ? -1 : (smj_rightRow1.getInt(2));
/* 734 */
/* 735 */         // generate join key for stream side
/* 736 */
/* 737 */         boolean bhj_isNull129 = smj_isNull16;
/* 738 */         long bhj_value129 = -1L;
/* 739 */         if (!smj_isNull16) {
/* 740 */           bhj_value129 = (long) smj_value18;
/* 741 */         }
/* 742 */         // find matches from HashedRelation
/* 743 */         UnsafeRow bhj_matched6 = bhj_isNull129 ? null: (UnsafeRow)bhj_relation6.getValue(bhj_value129);
/* 744 */         if (bhj_matched6 == null) continue;
/* 745 */
/* 746 */         bhj_numOutputRows6.add(1);
/* 747 */
/* 748 */         // generate join key for stream side
/* 749 */
/* 750 */         boolean bhj_isNull148 = smj_isNull6;
/* 751 */         long bhj_value148 = -1L;
/* 752 */         if (!smj_isNull6) {
/* 753 */           bhj_value148 = (long) smj_value8;
/* 754 */         }
/* 755 */         // find matches from HashedRelation
/* 756 */         UnsafeRow bhj_matched7 = bhj_isNull148 ? null: (UnsafeRow)bhj_relation7.getValue(bhj_value148);
/* 757 */         if (bhj_matched7 == null) continue;
/* 758 */
/* 759 */         bhj_numOutputRows7.add(1);
/* 760 */
/* 761 */         boolean smj_isNull17 = smj_rightRow1.isNullAt(3);
/* 762 */         int smj_value19 = smj_isNull17 ? -1 : (smj_rightRow1.getInt(3));
/* 763 */
/* 764 */         // generate join key for stream side
/* 765 */
/* 766 */         boolean bhj_isNull173 = smj_isNull17;
/* 767 */         long bhj_value173 = -1L;
/* 768 */         if (!smj_isNull17) {
/* 769 */           bhj_value173 = (long) smj_value19;
/* 770 */         }
/* 771 */         // find matches from HashedRelation
/* 772 */         UnsafeRow bhj_matched8 = bhj_isNull173 ? null: (UnsafeRow)bhj_relation8.getValue(bhj_value173);
/* 773 */         if (bhj_matched8 == null) continue;
/* 774 */
/* 775 */         bhj_numOutputRows8.add(1);
/* 776 */
/* 777 */         boolean bhj_isNull113 = bhj_matched5.isNullAt(1);
/* 778 */         int bhj_value113 = bhj_isNull113 ? -1 : (bhj_matched5.getInt(1));
/* 779 */
/* 780 */         // generate join key for stream side
/* 781 */
/* 782 */         boolean bhj_isNull201 = bhj_isNull113;
/* 783 */         long bhj_value201 = -1L;
/* 784 */         if (!bhj_isNull113) {
/* 785 */           bhj_value201 = (long) bhj_value113;
/* 786 */         }
/* 787 */         // find matches from HashedRelation
/* 788 */         UnsafeRow bhj_matched9 = bhj_isNull201 ? null: (UnsafeRow)bhj_relation9.getValue(bhj_value201);
/* 789 */         if (bhj_matched9 == null) continue;
/* 790 */
/* 791 */         bhj_numOutputRows9.add(1);
/* 792 */
/* 793 */         boolean bhj_isNull132 = bhj_matched6.isNullAt(1);
/* 794 */         int bhj_value132 = bhj_isNull132 ? -1 : (bhj_matched6.getInt(1));
/* 795 */
/* 796 */         // generate join key for stream side
/* 797 */
/* 798 */         boolean bhj_isNull224 = bhj_isNull132;
/* 799 */         long bhj_value224 = -1L;
/* 800 */         if (!bhj_isNull132) {
/* 801 */           bhj_value224 = (long) bhj_value132;
/* 802 */         }
/* 803 */         // find matches from HashedRelation
/* 804 */         UnsafeRow bhj_matched10 = bhj_isNull224 ? null: (UnsafeRow)bhj_relation10.getValue(bhj_value224);
/* 805 */         if (bhj_matched10 == null) continue;
/* 806 */
/* 807 */         bhj_numOutputRows10.add(1);
/* 808 */
/* 809 */         // generate join key for stream side
/* 810 */
/* 811 */         boolean bhj_isNull246 = smj_isNull2;
/* 812 */         long bhj_value246 = -1L;
/* 813 */         if (!smj_isNull2) {
/* 814 */           bhj_value246 = (long) smj_value4;
/* 815 */         }
/* 816 */         // find matches from HashedRelation
/* 817 */         UnsafeRow bhj_matched11 = bhj_isNull246 ? null: (UnsafeRow)bhj_relation11.getValue(bhj_value246);
/* 818 */         if (bhj_matched11 == null) continue;
/* 819 */
/* 820 */         bhj_numOutputRows11.add(1);
/* 821 */
/* 822 */         boolean bhj_isNull3 = bhj_matched.isNullAt(1);
/* 823 */         int bhj_value3 = bhj_isNull3 ? -1 : (bhj_matched.getInt(1));
/* 824 */         boolean bhj_isNull25 = bhj_matched1.isNullAt(1);
/* 825 */         int bhj_value25 = bhj_isNull25 ? -1 : (bhj_matched1.getInt(1));
/* 826 */         boolean bhj_isNull151 = bhj_matched7.isNullAt(1);
/* 827 */         UTF8String bhj_value151 = bhj_isNull151 ? null : (bhj_matched7.getUTF8String(1));
/* 828 */         boolean bhj_isNull152 = bhj_matched7.isNullAt(2);
/* 829 */         UTF8String bhj_value152 = bhj_isNull152 ? null : (bhj_matched7.getUTF8String(2));
/* 830 */         boolean bhj_isNull153 = bhj_matched7.isNullAt(3);
/* 831 */         UTF8String bhj_value153 = bhj_isNull153 ? null : (bhj_matched7.getUTF8String(3));
/* 832 */         boolean bhj_isNull154 = bhj_matched7.isNullAt(4);
/* 833 */         UTF8String bhj_value154 = bhj_isNull154 ? null : (bhj_matched7.getUTF8String(4));
/* 834 */         boolean bhj_isNull176 = bhj_matched8.isNullAt(1);
/* 835 */         UTF8String bhj_value176 = bhj_isNull176 ? null : (bhj_matched8.getUTF8String(1));
/* 836 */         boolean bhj_isNull177 = bhj_matched8.isNullAt(2);
/* 837 */         UTF8String bhj_value177 = bhj_isNull177 ? null : (bhj_matched8.getUTF8String(2));
/* 838 */         boolean bhj_isNull178 = bhj_matched8.isNullAt(3);
/* 839 */         UTF8String bhj_value178 = bhj_isNull178 ? null : (bhj_matched8.getUTF8String(3));
/* 840 */         boolean bhj_isNull179 = bhj_matched8.isNullAt(4);
/* 841 */         UTF8String bhj_value179 = bhj_isNull179 ? null : (bhj_matched8.getUTF8String(4));
/* 842 */         boolean bhj_isNull248 = bhj_matched11.isNullAt(0);
/* 843 */         int bhj_value248 = bhj_isNull248 ? -1 : (bhj_matched11.getInt(0));
/* 844 */         boolean bhj_isNull249 = bhj_matched11.isNullAt(1);
/* 845 */         UTF8String bhj_value249 = bhj_isNull249 ? null : (bhj_matched11.getUTF8String(1));
/* 846 */
/* 847 */         UnsafeRow agg_unsafeRowAggBuffer = null;
/* 848 */
/* 849 */         UnsafeRow agg_fastAggBuffer = null;
/* 850 */
/* 851 */         if (true) {
/* 852 */           if (!bhj_isNull249 && !bhj_isNull248 && !smj_isNull12 && !smj_isNull13 && !bhj_isNull151 && !bhj_isNull152 && !bhj_isNull153 && !bhj_isNull154 && !bhj_isNull176 && !bhj_isNull177 && !bhj_isNull178 && !bhj_isNull179 && !smj_isNull11 && !bhj_isNull3 && !bhj_isNull25) {
/* 853 */             agg_fastAggBuffer = agg_fastHashMap.findOrInsert(
/* 854 */               bhj_value249, bhj_value248, smj_value14, smj_value15, bhj_value151, bhj_value152, bhj_value153, bhj_value154, bhj_value176, bhj_value177, bhj_value178, bhj_value179, smj_value13, bhj_value3, bhj_value25);
/* 855 */           }
/* 856 */         }
/* 857 */
/* 858 */         if (agg_fastAggBuffer == null) {
/* 859 */           // generate grouping key
/* 860 */           agg_holder.reset();
/* 861 */
/* 862 */           agg_rowWriter.zeroOutNullBytes();
/* 863 */
/* 864 */           if (bhj_isNull249) {
/* 865 */             agg_rowWriter.setNullAt(0);
/* 866 */           } else {
/* 867 */             agg_rowWriter.write(0, bhj_value249);
/* 868 */           }
/* 869 */
/* 870 */           if (bhj_isNull248) {
/* 871 */             agg_rowWriter.setNullAt(1);
/* 872 */           } else {
/* 873 */             agg_rowWriter.write(1, bhj_value248);
/* 874 */           }
/* 875 */
/* 876 */           if (smj_isNull12) {
/* 877 */             agg_rowWriter.setNullAt(2);
/* 878 */           } else {
/* 879 */             agg_rowWriter.write(2, smj_value14);
/* 880 */           }
/* 881 */
/* 882 */           if (smj_isNull13) {
/* 883 */             agg_rowWriter.setNullAt(3);
/* 884 */           } else {
/* 885 */             agg_rowWriter.write(3, smj_value15);
/* 886 */           }
/* 887 */
/* 888 */           if (bhj_isNull151) {
/* 889 */             agg_rowWriter.setNullAt(4);
/* 890 */           } else {
/* 891 */             agg_rowWriter.write(4, bhj_value151);
/* 892 */           }
/* 893 */
/* 894 */           if (bhj_isNull152) {
/* 895 */             agg_rowWriter.setNullAt(5);
/* 896 */           } else {
/* 897 */             agg_rowWriter.write(5, bhj_value152);
/* 898 */           }
/* 899 */
/* 900 */           if (bhj_isNull153) {
/* 901 */             agg_rowWriter.setNullAt(6);
/* 902 */           } else {
/* 903 */             agg_rowWriter.write(6, bhj_value153);
/* 904 */           }
/* 905 */
/* 906 */           if (bhj_isNull154) {
/* 907 */             agg_rowWriter.setNullAt(7);
/* 908 */           } else {
/* 909 */             agg_rowWriter.write(7, bhj_value154);
/* 910 */           }
/* 911 */
/* 912 */           if (bhj_isNull176) {
/* 913 */             agg_rowWriter.setNullAt(8);
/* 914 */           } else {
/* 915 */             agg_rowWriter.write(8, bhj_value176);
/* 916 */           }
/* 917 */
/* 918 */           if (bhj_isNull177) {
/* 919 */             agg_rowWriter.setNullAt(9);
/* 920 */           } else {
/* 921 */             agg_rowWriter.write(9, bhj_value177);
/* 922 */           }
/* 923 */
/* 924 */           if (bhj_isNull178) {
/* 925 */             agg_rowWriter.setNullAt(10);
/* 926 */           } else {
/* 927 */             agg_rowWriter.write(10, bhj_value178);
/* 928 */           }
/* 929 */
/* 930 */           if (bhj_isNull179) {
/* 931 */             agg_rowWriter.setNullAt(11);
/* 932 */           } else {
/* 933 */             agg_rowWriter.write(11, bhj_value179);
/* 934 */           }
/* 935 */
/* 936 */           if (smj_isNull11) {
/* 937 */             agg_rowWriter.setNullAt(12);
/* 938 */           } else {
/* 939 */             agg_rowWriter.write(12, smj_value13);
/* 940 */           }
/* 941 */
/* 942 */           if (bhj_isNull3) {
/* 943 */             agg_rowWriter.setNullAt(13);
/* 944 */           } else {
/* 945 */             agg_rowWriter.write(13, bhj_value3);
/* 946 */           }
/* 947 */
/* 948 */           if (bhj_isNull25) {
/* 949 */             agg_rowWriter.setNullAt(14);
/* 950 */           } else {
/* 951 */             agg_rowWriter.write(14, bhj_value25);
/* 952 */           }
/* 953 */           agg_result15.setTotalSize(agg_holder.totalSize());
/* 954 */           agg_value38 = 42;
/* 955 */
/* 956 */           if (!bhj_isNull249) {
/* 957 */             agg_value38 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(bhj_value249.getBaseObject(), bhj_value249.getBaseOffset(), bhj_value249.numBytes(), agg_value38);
/* 958 */           }
/* 959 */
/* 960 */           if (!bhj_isNull248) {
/* 961 */             agg_value38 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(bhj_value248, agg_value38);
/* 962 */           }
/* 963 */
/* 964 */           if (!smj_isNull12) {
/* 965 */             agg_value38 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(smj_value14.getBaseObject(), smj_value14.getBaseOffset(), smj_value14.numBytes(), agg_value38);
/* 966 */           }
/* 967 */
/* 968 */           if (!smj_isNull13) {
/* 969 */             agg_value38 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(smj_value15.getBaseObject(), smj_value15.getBaseOffset(), smj_value15.numBytes(), agg_value38);
/* 970 */           }
/* 971 */
/* 972 */           if (!bhj_isNull151) {
/* 973 */             agg_value38 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(bhj_value151.getBaseObject(), bhj_value151.getBaseOffset(), bhj_value151.numBytes(), agg_value38);
/* 974 */           }
/* 975 */
/* 976 */           if (!bhj_isNull152) {
/* 977 */             agg_value38 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(bhj_value152.getBaseObject(), bhj_value152.getBaseOffset(), bhj_value152.numBytes(), agg_value38);
/* 978 */           }
/* 979 */
/* 980 */           if (!bhj_isNull153) {
/* 981 */             agg_value38 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(bhj_value153.getBaseObject(), bhj_value153.getBaseOffset(), bhj_value153.numBytes(), agg_value38);
/* 982 */           }
/* 983 */
/* 984 */           if (!bhj_isNull154) {
/* 985 */             agg_value38 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(bhj_value154.getBaseObject(), bhj_value154.getBaseOffset(), bhj_value154.numBytes(), agg_value38);
/* 986 */           }
/* 987 */
/* 988 */           if (!bhj_isNull176) {
/* 989 */             agg_value38 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(bhj_value176.getBaseObject(), bhj_value176.getBaseOffset(), bhj_value176.numBytes(), agg_value38);
/* 990 */           }
/* 991 */
/* 992 */           if (!bhj_isNull177) {
/* 993 */             agg_value38 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(bhj_value177.getBaseObject(), bhj_value177.getBaseOffset(), bhj_value177.numBytes(), agg_value38);
/* 994 */           }
/* 995 */
/* 996 */           if (!bhj_isNull178) {
/* 997 */             agg_value38 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(bhj_value178.getBaseObject(), bhj_value178.getBaseOffset(), bhj_value178.numBytes(), agg_value38);
/* 998 */           }
/* 999 */
/* 1000 */           if (!bhj_isNull179) {
/* 1001 */             agg_value38 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(bhj_value179.getBaseObject(), bhj_value179.getBaseOffset(), bhj_value179.numBytes(), agg_value38);
/* 1002 */           }
/* 1003 */
/* 1004 */           if (!smj_isNull11) {
/* 1005 */             agg_value38 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(smj_value13, agg_value38);
/* 1006 */           }
/* 1007 */
/* 1008 */           if (!bhj_isNull3) {
/* 1009 */             agg_value38 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(bhj_value3, agg_value38);
/* 1010 */           }
/* 1011 */
/* 1012 */           if (!bhj_isNull25) {
/* 1013 */             agg_value38 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(bhj_value25, agg_value38);
/* 1014 */           }
/* 1015 */           if (true) {
/* 1016 */             // try to get the buffer from hash map
/* 1017 */             agg_unsafeRowAggBuffer =
/* 1018 */             agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result15, agg_value38);
/* 1019 */           }
/* 1020 */           if (agg_unsafeRowAggBuffer == null) {
/* 1021 */             if (agg_sorter == null) {
/* 1022 */               agg_sorter = agg_hashMap.destructAndCreateExternalSorter();
/* 1023 */             } else {
/* 1024 */               agg_sorter.merge(agg_hashMap.destructAndCreateExternalSorter());
/* 1025 */             }
/* 1026 */
/* 1027 */             // the hash map had be spilled, it should have enough memory now,
/* 1028 */             // try  to allocate buffer again.
/* 1029 */             agg_unsafeRowAggBuffer =
/* 1030 */             agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result15, agg_value38);
/* 1031 */             if (agg_unsafeRowAggBuffer == null) {
/* 1032 */               // failed to allocate the first page
/* 1033 */               throw new OutOfMemoryError("No enough memory for aggregation");
/* 1034 */             }
/* 1035 */           }
/* 1036 */         }
/* 1037 */
/* 1038 */         if (agg_fastAggBuffer != null) {
/* 1039 */           // update fast row
/* 1040 */
/* 1041 */           // common sub-expressions
/* 1042 */
/* 1043 */           // evaluate aggregate function
/* 1044 */           boolean agg_isNull77 = false;
/* 1045 */
/* 1046 */           long agg_value82 = agg_fastAggBuffer.getLong(0);
/* 1047 */
/* 1048 */           long agg_value81 = -1L;
/* 1049 */           agg_value81 = agg_value82 + 1L;
/* 1050 */           boolean agg_isNull81 = true;
/* 1051 */           double agg_value85 = -1.0;
/* 1052 */
/* 1053 */           boolean agg_isNull83 = agg_fastAggBuffer.isNullAt(1);
/* 1054 */           double agg_value87 = agg_isNull83 ? -1.0 : (agg_fastAggBuffer.getDouble(1));
/* 1055 */           boolean agg_isNull82 = agg_isNull83;
/* 1056 */           double agg_value86 = agg_value87;
/* 1057 */           if (agg_isNull82) {
/* 1058 */             boolean agg_isNull84 = false;
/* 1059 */             double agg_value88 = -1.0;
/* 1060 */             if (!false) {
/* 1061 */               agg_value88 = (double) 0;
/* 1062 */             }
/* 1063 */             if (!agg_isNull84) {
/* 1064 */               agg_isNull82 = false;
/* 1065 */               agg_value86 = agg_value88;
/* 1066 */             }
/* 1067 */           }
/* 1068 */
/* 1069 */           if (!smj_isNull8) {
/* 1070 */             agg_isNull81 = false; // resultCode could change nullability.
/* 1071 */             agg_value85 = agg_value86 + smj_value10;
/* 1072 */
/* 1073 */           }
/* 1074 */           boolean agg_isNull80 = agg_isNull81;
/* 1075 */           double agg_value84 = agg_value85;
/* 1076 */           if (agg_isNull80) {
/* 1077 */             boolean agg_isNull87 = agg_fastAggBuffer.isNullAt(1);
/* 1078 */             double agg_value91 = agg_isNull87 ? -1.0 : (agg_fastAggBuffer.getDouble(1));
/* 1079 */             if (!agg_isNull87) {
/* 1080 */               agg_isNull80 = false;
/* 1081 */               agg_value84 = agg_value91;
/* 1082 */             }
/* 1083 */           }
/* 1084 */           boolean agg_isNull89 = true;
/* 1085 */           double agg_value93 = -1.0;
/* 1086 */
/* 1087 */           boolean agg_isNull91 = agg_fastAggBuffer.isNullAt(2);
/* 1088 */           double agg_value95 = agg_isNull91 ? -1.0 : (agg_fastAggBuffer.getDouble(2));
/* 1089 */           boolean agg_isNull90 = agg_isNull91;
/* 1090 */           double agg_value94 = agg_value95;
/* 1091 */           if (agg_isNull90) {
/* 1092 */             boolean agg_isNull92 = false;
/* 1093 */             double agg_value96 = -1.0;
/* 1094 */             if (!false) {
/* 1095 */               agg_value96 = (double) 0;
/* 1096 */             }
/* 1097 */             if (!agg_isNull92) {
/* 1098 */               agg_isNull90 = false;
/* 1099 */               agg_value94 = agg_value96;
/* 1100 */             }
/* 1101 */           }
/* 1102 */
/* 1103 */           if (!smj_isNull9) {
/* 1104 */             agg_isNull89 = false; // resultCode could change nullability.
/* 1105 */             agg_value93 = agg_value94 + smj_value11;
/* 1106 */
/* 1107 */           }
/* 1108 */           boolean agg_isNull88 = agg_isNull89;
/* 1109 */           double agg_value92 = agg_value93;
/* 1110 */           if (agg_isNull88) {
/* 1111 */             boolean agg_isNull95 = agg_fastAggBuffer.isNullAt(2);
/* 1112 */             double agg_value99 = agg_isNull95 ? -1.0 : (agg_fastAggBuffer.getDouble(2));
/* 1113 */             if (!agg_isNull95) {
/* 1114 */               agg_isNull88 = false;
/* 1115 */               agg_value92 = agg_value99;
/* 1116 */             }
/* 1117 */           }
/* 1118 */           boolean agg_isNull97 = true;
/* 1119 */           double agg_value101 = -1.0;
/* 1120 */
/* 1121 */           boolean agg_isNull99 = agg_fastAggBuffer.isNullAt(3);
/* 1122 */           double agg_value103 = agg_isNull99 ? -1.0 : (agg_fastAggBuffer.getDouble(3));
/* 1123 */           boolean agg_isNull98 = agg_isNull99;
/* 1124 */           double agg_value102 = agg_value103;
/* 1125 */           if (agg_isNull98) {
/* 1126 */             boolean agg_isNull100 = false;
/* 1127 */             double agg_value104 = -1.0;
/* 1128 */             if (!false) {
/* 1129 */               agg_value104 = (double) 0;
/* 1130 */             }
/* 1131 */             if (!agg_isNull100) {
/* 1132 */               agg_isNull98 = false;
/* 1133 */               agg_value102 = agg_value104;
/* 1134 */             }
/* 1135 */           }
/* 1136 */
/* 1137 */           if (!smj_isNull10) {
/* 1138 */             agg_isNull97 = false; // resultCode could change nullability.
/* 1139 */             agg_value101 = agg_value102 + smj_value12;
/* 1140 */
/* 1141 */           }
/* 1142 */           boolean agg_isNull96 = agg_isNull97;
/* 1143 */           double agg_value100 = agg_value101;
/* 1144 */           if (agg_isNull96) {
/* 1145 */             boolean agg_isNull103 = agg_fastAggBuffer.isNullAt(3);
/* 1146 */             double agg_value107 = agg_isNull103 ? -1.0 : (agg_fastAggBuffer.getDouble(3));
/* 1147 */             if (!agg_isNull103) {
/* 1148 */               agg_isNull96 = false;
/* 1149 */               agg_value100 = agg_value107;
/* 1150 */             }
/* 1151 */           }
/* 1152 */           // update fast row
/* 1153 */           agg_fastAggBuffer.setLong(0, agg_value81);
/* 1154 */
/* 1155 */           if (!agg_isNull80) {
/* 1156 */             agg_fastAggBuffer.setDouble(1, agg_value84);
/* 1157 */           } else {
/* 1158 */             agg_fastAggBuffer.setNullAt(1);
/* 1159 */           }
/* 1160 */
/* 1161 */           if (!agg_isNull88) {
/* 1162 */             agg_fastAggBuffer.setDouble(2, agg_value92);
/* 1163 */           } else {
/* 1164 */             agg_fastAggBuffer.setNullAt(2);
/* 1165 */           }
/* 1166 */
/* 1167 */           if (!agg_isNull96) {
/* 1168 */             agg_fastAggBuffer.setDouble(3, agg_value100);
/* 1169 */           } else {
/* 1170 */             agg_fastAggBuffer.setNullAt(3);
/* 1171 */           }
/* 1172 */
/* 1173 */         } else {
/* 1174 */           // update unsafe row
/* 1175 */
/* 1176 */           // common sub-expressions
/* 1177 */
/* 1178 */           // evaluate aggregate function
/* 1179 */           boolean agg_isNull50 = false;
/* 1180 */
/* 1181 */           long agg_value55 = agg_unsafeRowAggBuffer.getLong(0);
/* 1182 */
/* 1183 */           long agg_value54 = -1L;
/* 1184 */           agg_value54 = agg_value55 + 1L;
/* 1185 */           boolean agg_isNull54 = true;
/* 1186 */           double agg_value58 = -1.0;
/* 1187 */
/* 1188 */           boolean agg_isNull56 = agg_unsafeRowAggBuffer.isNullAt(1);
/* 1189 */           double agg_value60 = agg_isNull56 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(1));
/* 1190 */           boolean agg_isNull55 = agg_isNull56;
/* 1191 */           double agg_value59 = agg_value60;
/* 1192 */           if (agg_isNull55) {
/* 1193 */             boolean agg_isNull57 = false;
/* 1194 */             double agg_value61 = -1.0;
/* 1195 */             if (!false) {
/* 1196 */               agg_value61 = (double) 0;
/* 1197 */             }
/* 1198 */             if (!agg_isNull57) {
/* 1199 */               agg_isNull55 = false;
/* 1200 */               agg_value59 = agg_value61;
/* 1201 */             }
/* 1202 */           }
/* 1203 */
/* 1204 */           if (!smj_isNull8) {
/* 1205 */             agg_isNull54 = false; // resultCode could change nullability.
/* 1206 */             agg_value58 = agg_value59 + smj_value10;
/* 1207 */
/* 1208 */           }
/* 1209 */           boolean agg_isNull53 = agg_isNull54;
/* 1210 */           double agg_value57 = agg_value58;
/* 1211 */           if (agg_isNull53) {
/* 1212 */             boolean agg_isNull60 = agg_unsafeRowAggBuffer.isNullAt(1);
/* 1213 */             double agg_value64 = agg_isNull60 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(1));
/* 1214 */             if (!agg_isNull60) {
/* 1215 */               agg_isNull53 = false;
/* 1216 */               agg_value57 = agg_value64;
/* 1217 */             }
/* 1218 */           }
/* 1219 */           boolean agg_isNull62 = true;
/* 1220 */           double agg_value66 = -1.0;
/* 1221 */
/* 1222 */           boolean agg_isNull64 = agg_unsafeRowAggBuffer.isNullAt(2);
/* 1223 */           double agg_value68 = agg_isNull64 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(2));
/* 1224 */           boolean agg_isNull63 = agg_isNull64;
/* 1225 */           double agg_value67 = agg_value68;
/* 1226 */           if (agg_isNull63) {
/* 1227 */             boolean agg_isNull65 = false;
/* 1228 */             double agg_value69 = -1.0;
/* 1229 */             if (!false) {
/* 1230 */               agg_value69 = (double) 0;
/* 1231 */             }
/* 1232 */             if (!agg_isNull65) {
/* 1233 */               agg_isNull63 = false;
/* 1234 */               agg_value67 = agg_value69;
/* 1235 */             }
/* 1236 */           }
/* 1237 */
/* 1238 */           if (!smj_isNull9) {
/* 1239 */             agg_isNull62 = false; // resultCode could change nullability.
/* 1240 */             agg_value66 = agg_value67 + smj_value11;
/* 1241 */
/* 1242 */           }
/* 1243 */           boolean agg_isNull61 = agg_isNull62;
/* 1244 */           double agg_value65 = agg_value66;
/* 1245 */           if (agg_isNull61) {
/* 1246 */             boolean agg_isNull68 = agg_unsafeRowAggBuffer.isNullAt(2);
/* 1247 */             double agg_value72 = agg_isNull68 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(2));
/* 1248 */             if (!agg_isNull68) {
/* 1249 */               agg_isNull61 = false;
/* 1250 */               agg_value65 = agg_value72;
/* 1251 */             }
/* 1252 */           }
/* 1253 */           boolean agg_isNull70 = true;
/* 1254 */           double agg_value74 = -1.0;
/* 1255 */
/* 1256 */           boolean agg_isNull72 = agg_unsafeRowAggBuffer.isNullAt(3);
/* 1257 */           double agg_value76 = agg_isNull72 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(3));
/* 1258 */           boolean agg_isNull71 = agg_isNull72;
/* 1259 */           double agg_value75 = agg_value76;
/* 1260 */           if (agg_isNull71) {
/* 1261 */             boolean agg_isNull73 = false;
/* 1262 */             double agg_value77 = -1.0;
/* 1263 */             if (!false) {
/* 1264 */               agg_value77 = (double) 0;
/* 1265 */             }
/* 1266 */             if (!agg_isNull73) {
/* 1267 */               agg_isNull71 = false;
/* 1268 */               agg_value75 = agg_value77;
/* 1269 */             }
/* 1270 */           }
/* 1271 */
/* 1272 */           if (!smj_isNull10) {
/* 1273 */             agg_isNull70 = false; // resultCode could change nullability.
/* 1274 */             agg_value74 = agg_value75 + smj_value12;
/* 1275 */
/* 1276 */           }
/* 1277 */           boolean agg_isNull69 = agg_isNull70;
/* 1278 */           double agg_value73 = agg_value74;
/* 1279 */           if (agg_isNull69) {
/* 1280 */             boolean agg_isNull76 = agg_unsafeRowAggBuffer.isNullAt(3);
/* 1281 */             double agg_value80 = agg_isNull76 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(3));
/* 1282 */             if (!agg_isNull76) {
/* 1283 */               agg_isNull69 = false;
/* 1284 */               agg_value73 = agg_value80;
/* 1285 */             }
/* 1286 */           }
/* 1287 */           // update unsafe row buffer
/* 1288 */           agg_unsafeRowAggBuffer.setLong(0, agg_value54);
/* 1289 */
/* 1290 */           if (!agg_isNull53) {
/* 1291 */             agg_unsafeRowAggBuffer.setDouble(1, agg_value57);
/* 1292 */           } else {
/* 1293 */             agg_unsafeRowAggBuffer.setNullAt(1);
/* 1294 */           }
/* 1295 */
/* 1296 */           if (!agg_isNull61) {
/* 1297 */             agg_unsafeRowAggBuffer.setDouble(2, agg_value65);
/* 1298 */           } else {
/* 1299 */             agg_unsafeRowAggBuffer.setNullAt(2);
/* 1300 */           }
/* 1301 */
/* 1302 */           if (!agg_isNull69) {
/* 1303 */             agg_unsafeRowAggBuffer.setDouble(3, agg_value73);
/* 1304 */           } else {
/* 1305 */             agg_unsafeRowAggBuffer.setNullAt(3);
/* 1306 */           }
/* 1307 */
/* 1308 */         }
/* 1309 */
/* 1310 */       }
/* 1311 */       if (shouldStop()) return;
/* 1312 */     }
/* 1313 */
/* 1314 */     agg_fastHashMapIter = agg_fastHashMap.rowIterator();
/* 1315 */
/* 1316 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 1317 */   }
/* 1318 */
/* 1319 */   private void wholestagecodegen_init_5() {
/* 1320 */     this.project_rowWriter5 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder5, 13);
/* 1321 */     this.bhj_broadcast5 = (org.apache.spark.broadcast.TorrentBroadcast) references[33];
/* 1322 */
/* 1323 */     bhj_relation5 = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast5.value()).asReadOnlyCopy();
/* 1324 */     incPeakExecutionMemory(bhj_relation5.estimatedSize());
/* 1325 */
/* 1326 */     this.bhj_numOutputRows5 = (org.apache.spark.sql.execution.metric.SQLMetric) references[34];
/* 1327 */     bhj_result5 = new UnsafeRow(15);
/* 1328 */     this.bhj_holder5 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result5, 64);
/* 1329 */     this.bhj_rowWriter5 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder5, 15);
/* 1330 */     project_result6 = new UnsafeRow(13);
/* 1331 */     this.project_holder6 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result6, 64);
/* 1332 */     this.project_rowWriter6 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder6, 13);
/* 1333 */     this.bhj_broadcast6 = (org.apache.spark.broadcast.TorrentBroadcast) references[35];
/* 1334 */
/* 1335 */   }
/* 1336 */
/* 1337 */   private void wholestagecodegen_init_8() {
/* 1338 */     this.bhj_rowWriter8 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder8, 21);
/* 1339 */     project_result9 = new UnsafeRow(19);
/* 1340 */     this.project_holder9 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result9, 320);
/* 1341 */     this.project_rowWriter9 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder9, 19);
/* 1342 */     this.bhj_broadcast9 = (org.apache.spark.broadcast.TorrentBroadcast) references[41];
/* 1343 */
/* 1344 */     bhj_relation9 = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast9.value()).asReadOnlyCopy();
/* 1345 */     incPeakExecutionMemory(bhj_relation9.estimatedSize());
/* 1346 */
/* 1347 */     this.bhj_numOutputRows9 = (org.apache.spark.sql.execution.metric.SQLMetric) references[42];
/* 1348 */     bhj_result9 = new UnsafeRow(20);
/* 1349 */     this.bhj_holder9 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result9, 320);
/* 1350 */     this.bhj_rowWriter9 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder9, 20);
/* 1351 */     project_result10 = new UnsafeRow(18);
/* 1352 */     this.project_holder10 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result10, 320);
/* 1353 */
/* 1354 */   }
/* 1355 */
/* 1356 */   private void wholestagecodegen_init_2() {
/* 1357 */     bhj_relation1 = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast1.value()).asReadOnlyCopy();
/* 1358 */     incPeakExecutionMemory(bhj_relation1.estimatedSize());
/* 1359 */
/* 1360 */     this.bhj_numOutputRows1 = (org.apache.spark.sql.execution.metric.SQLMetric) references[26];
/* 1361 */     bhj_result1 = new UnsafeRow(18);
/* 1362 */     this.bhj_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result1, 64);
/* 1363 */     this.bhj_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder1, 18);
/* 1364 */     project_result2 = new UnsafeRow(16);
/* 1365 */     this.project_holder2 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result2, 64);
/* 1366 */     this.project_rowWriter2 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder2, 16);
/* 1367 */     this.bhj_broadcast2 = (org.apache.spark.broadcast.TorrentBroadcast) references[27];
/* 1368 */
/* 1369 */     bhj_relation2 = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast2.value()).asReadOnlyCopy();
/* 1370 */     incPeakExecutionMemory(bhj_relation2.estimatedSize());
/* 1371 */
/* 1372 */   }
/* 1373 */
/* 1374 */   private void wholestagecodegen_init_11() {
/* 1375 */     agg_unsafeRowJoiner = agg_plan.createUnsafeJoiner();
/* 1376 */     this.wholestagecodegen_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[47];
/* 1377 */     this.wholestagecodegen_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[48];
/* 1378 */
/* 1379 */   }
/* 1380 */
/* 1381 */   private void wholestagecodegen_init_1() {
/* 1382 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 16);
/* 1383 */     this.bhj_broadcast = (org.apache.spark.broadcast.TorrentBroadcast) references[23];
/* 1384 */
/* 1385 */     bhj_relation = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast.value()).asReadOnlyCopy();
/* 1386 */     incPeakExecutionMemory(bhj_relation.estimatedSize());
/* 1387 */
/* 1388 */     this.bhj_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[24];
/* 1389 */     bhj_result = new UnsafeRow(18);
/* 1390 */     this.bhj_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result, 64);
/* 1391 */     this.bhj_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder, 18);
/* 1392 */     project_result1 = new UnsafeRow(16);
/* 1393 */     this.project_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result1, 64);
/* 1394 */     this.project_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder1, 16);
/* 1395 */     this.bhj_broadcast1 = (org.apache.spark.broadcast.TorrentBroadcast) references[25];
/* 1396 */
/* 1397 */   }
/* 1398 */
/* 1399 */   private void wholestagecodegen_init_4() {
/* 1400 */     this.bhj_rowWriter3 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder3, 18);
/* 1401 */     project_result4 = new UnsafeRow(14);
/* 1402 */     this.project_holder4 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result4, 64);
/* 1403 */     this.project_rowWriter4 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder4, 14);
/* 1404 */     this.bhj_broadcast4 = (org.apache.spark.broadcast.TorrentBroadcast) references[31];
/* 1405 */
/* 1406 */     bhj_relation4 = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast4.value()).asReadOnlyCopy();
/* 1407 */     incPeakExecutionMemory(bhj_relation4.estimatedSize());
/* 1408 */
/* 1409 */     this.bhj_numOutputRows4 = (org.apache.spark.sql.execution.metric.SQLMetric) references[32];
/* 1410 */     bhj_result4 = new UnsafeRow(15);
/* 1411 */     this.bhj_holder4 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result4, 64);
/* 1412 */     this.bhj_rowWriter4 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder4, 15);
/* 1413 */     project_result5 = new UnsafeRow(13);
/* 1414 */     this.project_holder5 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result5, 64);
/* 1415 */
/* 1416 */   }
/* 1417 */
/* 1418 */   private void wholestagecodegen_init_7() {
/* 1419 */     this.bhj_numOutputRows7 = (org.apache.spark.sql.execution.metric.SQLMetric) references[38];
/* 1420 */     bhj_result7 = new UnsafeRow(18);
/* 1421 */     this.bhj_holder7 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result7, 192);
/* 1422 */     this.bhj_rowWriter7 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder7, 18);
/* 1423 */     project_result8 = new UnsafeRow(16);
/* 1424 */     this.project_holder8 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result8, 192);
/* 1425 */     this.project_rowWriter8 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder8, 16);
/* 1426 */     this.bhj_broadcast8 = (org.apache.spark.broadcast.TorrentBroadcast) references[39];
/* 1427 */
/* 1428 */     bhj_relation8 = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast8.value()).asReadOnlyCopy();
/* 1429 */     incPeakExecutionMemory(bhj_relation8.estimatedSize());
/* 1430 */
/* 1431 */     this.bhj_numOutputRows8 = (org.apache.spark.sql.execution.metric.SQLMetric) references[40];
/* 1432 */     bhj_result8 = new UnsafeRow(21);
/* 1433 */     this.bhj_holder8 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result8, 320);
/* 1434 */
/* 1435 */   }
/* 1436 */
/* 1437 */   private void wholestagecodegen_init_6() {
/* 1438 */     bhj_relation6 = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast6.value()).asReadOnlyCopy();
/* 1439 */     incPeakExecutionMemory(bhj_relation6.estimatedSize());
/* 1440 */
/* 1441 */     this.bhj_numOutputRows6 = (org.apache.spark.sql.execution.metric.SQLMetric) references[36];
/* 1442 */     bhj_result6 = new UnsafeRow(15);
/* 1443 */     this.bhj_holder6 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result6, 64);
/* 1444 */     this.bhj_rowWriter6 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder6, 15);
/* 1445 */     project_result7 = new UnsafeRow(13);
/* 1446 */     this.project_holder7 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result7, 64);
/* 1447 */     this.project_rowWriter7 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder7, 13);
/* 1448 */     this.bhj_broadcast7 = (org.apache.spark.broadcast.TorrentBroadcast) references[37];
/* 1449 */
/* 1450 */     bhj_relation7 = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast7.value()).asReadOnlyCopy();
/* 1451 */     incPeakExecutionMemory(bhj_relation7.estimatedSize());
/* 1452 */
/* 1453 */   }
/* 1454 */
/* 1455 */   protected void processNext() throws java.io.IOException {
/* 1456 */     if (!agg_initAgg) {
/* 1457 */       agg_initAgg = true;
/* 1458 */       long wholestagecodegen_beforeAgg = System.nanoTime();
/* 1459 */       agg_doAggregateWithKeys();
/* 1460 */       wholestagecodegen_aggTime.add((System.nanoTime() - wholestagecodegen_beforeAgg) / 1000000);
/* 1461 */     }
/* 1462 */
/* 1463 */     // output the result
/* 1464 */
/* 1465 */     while (agg_fastHashMapIter.next()) {
/* 1466 */       wholestagecodegen_numOutputRows.add(1);
/* 1467 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_fastHashMapIter.getKey();
/* 1468 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_fastHashMapIter.getValue();
/* 1469 */
/* 1470 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey, agg_aggBuffer);
/* 1471 */
/* 1472 */       append(agg_resultRow.copy());
/* 1473 */
/* 1474 */       if (shouldStop()) return;
/* 1475 */     }
/* 1476 */     agg_fastHashMap.close();
/* 1477 */
/* 1478 */     while (agg_mapIter.next()) {
/* 1479 */       wholestagecodegen_numOutputRows.add(1);
/* 1480 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter.getKey();
/* 1481 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter.getValue();
/* 1482 */
/* 1483 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey, agg_aggBuffer);
/* 1484 */
/* 1485 */       append(agg_resultRow.copy());
/* 1486 */
/* 1487 */       if (shouldStop()) return;
/* 1488 */     }
/* 1489 */
/* 1490 */     agg_mapIter.close();
/* 1491 */     if (agg_sorter == null) {
/* 1492 */       agg_hashMap.free();
/* 1493 */     }
/* 1494 */   }
/* 1495 */ }
