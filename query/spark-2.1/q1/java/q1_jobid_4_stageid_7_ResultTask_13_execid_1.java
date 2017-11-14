/* 001 */ public Object generate(Object[] references) {
/* 002 */   return new GeneratedIterator(references);
/* 003 */ }
/* 004 */
/* 005 */ final class GeneratedIterator extends org.apache.spark.sql.execution.BufferedRowIterator {
/* 006 */   private Object[] references;
/* 007 */   private scala.collection.Iterator[] inputs;
/* 008 */   private boolean agg_initAgg;
/* 009 */   private boolean agg_bufIsNull;
/* 010 */   private double agg_bufValue;
/* 011 */   private org.apache.spark.sql.execution.aggregate.HashAggregateExec agg_plan;
/* 012 */   private org.apache.spark.sql.execution.UnsafeFixedWidthAggregationMap agg_hashMap;
/* 013 */   private org.apache.spark.sql.execution.UnsafeKVExternalSorter agg_sorter;
/* 014 */   private org.apache.spark.unsafe.KVIterator agg_mapIter;
/* 015 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_peakMemory;
/* 016 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_spillSize;
/* 017 */   private scala.collection.Iterator inputadapter_input;
/* 018 */   private UnsafeRow agg_result;
/* 019 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder;
/* 020 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter;
/* 021 */   private int agg_value6;
/* 022 */   private UnsafeRow agg_result1;
/* 023 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder1;
/* 024 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter1;
/* 025 */   private org.apache.spark.sql.execution.metric.SQLMetric filter_numOutputRows;
/* 026 */   private UnsafeRow filter_result;
/* 027 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder filter_holder;
/* 028 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter filter_rowWriter;
/* 029 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast;
/* 030 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation;
/* 031 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows;
/* 032 */   private UnsafeRow bhj_result;
/* 033 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder;
/* 034 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter;
/* 035 */   private UnsafeRow project_result;
/* 036 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder;
/* 037 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter;
/* 038 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast1;
/* 039 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation1;
/* 040 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows1;
/* 041 */   private UnsafeRow bhj_result1;
/* 042 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder1;
/* 043 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter1;
/* 044 */   private UnsafeRow project_result1;
/* 045 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder1;
/* 046 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter1;
/* 047 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast2;
/* 048 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation2;
/* 049 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows2;
/* 050 */   private UnsafeRow bhj_result2;
/* 051 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder2;
/* 052 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter2;
/* 053 */   private UnsafeRow project_result2;
/* 054 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder2;
/* 055 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter2;
/* 056 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_numOutputRows;
/* 057 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_aggTime;
/* 058 */
/* 059 */   public GeneratedIterator(Object[] references) {
/* 060 */     this.references = references;
/* 061 */   }
/* 062 */
/* 063 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 064 */     partitionIndex = index;
/* 065 */     this.inputs = inputs;
/* 066 */     wholestagecodegen_init_0();
/* 067 */     wholestagecodegen_init_1();
/* 068 */     wholestagecodegen_init_2();
/* 069 */     wholestagecodegen_init_3();
/* 070 */
/* 071 */   }
/* 072 */
/* 073 */   private void wholestagecodegen_init_0() {
/* 074 */     agg_initAgg = false;
/* 075 */
/* 076 */     this.agg_plan = (org.apache.spark.sql.execution.aggregate.HashAggregateExec) references[0];
/* 077 */
/* 078 */     this.agg_peakMemory = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 079 */     this.agg_spillSize = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 080 */     inputadapter_input = inputs[0];
/* 081 */     agg_result = new UnsafeRow(2);
/* 082 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result, 0);
/* 083 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 2);
/* 084 */
/* 085 */     agg_result1 = new UnsafeRow(3);
/* 086 */     this.agg_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result1, 0);
/* 087 */     this.agg_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder1, 3);
/* 088 */     this.filter_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[3];
/* 089 */     filter_result = new UnsafeRow(3);
/* 090 */     this.filter_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(filter_result, 0);
/* 091 */
/* 092 */   }
/* 093 */
/* 094 */   private void wholestagecodegen_init_3() {
/* 095 */     this.bhj_numOutputRows2 = (org.apache.spark.sql.execution.metric.SQLMetric) references[9];
/* 096 */     bhj_result2 = new UnsafeRow(3);
/* 097 */     this.bhj_holder2 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result2, 32);
/* 098 */     this.bhj_rowWriter2 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder2, 3);
/* 099 */     project_result2 = new UnsafeRow(1);
/* 100 */     this.project_holder2 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result2, 32);
/* 101 */     this.project_rowWriter2 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder2, 1);
/* 102 */     this.wholestagecodegen_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[10];
/* 103 */     this.wholestagecodegen_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[11];
/* 104 */
/* 105 */   }
/* 106 */
/* 107 */   private void agg_doAggregateWithKeys() throws java.io.IOException {
/* 108 */     agg_hashMap = agg_plan.createHashMap();
/* 109 */
/* 110 */     while (inputadapter_input.hasNext()) {
/* 111 */       InternalRow inputadapter_row = (InternalRow) inputadapter_input.next();
/* 112 */       boolean inputadapter_isNull = inputadapter_row.isNullAt(0);
/* 113 */       long inputadapter_value = inputadapter_isNull ? -1L : (inputadapter_row.getLong(0));
/* 114 */       boolean inputadapter_isNull1 = inputadapter_row.isNullAt(1);
/* 115 */       long inputadapter_value1 = inputadapter_isNull1 ? -1L : (inputadapter_row.getLong(1));
/* 116 */       boolean inputadapter_isNull2 = inputadapter_row.isNullAt(2);
/* 117 */       double inputadapter_value2 = inputadapter_isNull2 ? -1.0 : (inputadapter_row.getDouble(2));
/* 118 */
/* 119 */       UnsafeRow agg_unsafeRowAggBuffer = null;
/* 120 */
/* 121 */       UnsafeRow agg_fastAggBuffer = null;
/* 122 */
/* 123 */       if (agg_fastAggBuffer == null) {
/* 124 */         // generate grouping key
/* 125 */         agg_rowWriter.zeroOutNullBytes();
/* 126 */
/* 127 */         if (inputadapter_isNull) {
/* 128 */           agg_rowWriter.setNullAt(0);
/* 129 */         } else {
/* 130 */           agg_rowWriter.write(0, inputadapter_value);
/* 131 */         }
/* 132 */
/* 133 */         if (inputadapter_isNull1) {
/* 134 */           agg_rowWriter.setNullAt(1);
/* 135 */         } else {
/* 136 */           agg_rowWriter.write(1, inputadapter_value1);
/* 137 */         }
/* 138 */         agg_value6 = 42;
/* 139 */
/* 140 */         if (!inputadapter_isNull) {
/* 141 */           agg_value6 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashLong(inputadapter_value, agg_value6);
/* 142 */         }
/* 143 */
/* 144 */         if (!inputadapter_isNull1) {
/* 145 */           agg_value6 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashLong(inputadapter_value1, agg_value6);
/* 146 */         }
/* 147 */         if (true) {
/* 148 */           // try to get the buffer from hash map
/* 149 */           agg_unsafeRowAggBuffer =
/* 150 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result, agg_value6);
/* 151 */         }
/* 152 */         if (agg_unsafeRowAggBuffer == null) {
/* 153 */           if (agg_sorter == null) {
/* 154 */             agg_sorter = agg_hashMap.destructAndCreateExternalSorter();
/* 155 */           } else {
/* 156 */             agg_sorter.merge(agg_hashMap.destructAndCreateExternalSorter());
/* 157 */           }
/* 158 */
/* 159 */           // the hash map had be spilled, it should have enough memory now,
/* 160 */           // try  to allocate buffer again.
/* 161 */           agg_unsafeRowAggBuffer =
/* 162 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result, agg_value6);
/* 163 */           if (agg_unsafeRowAggBuffer == null) {
/* 164 */             // failed to allocate the first page
/* 165 */             throw new OutOfMemoryError("No enough memory for aggregation");
/* 166 */           }
/* 167 */         }
/* 168 */       }
/* 169 */
/* 170 */       if (agg_fastAggBuffer != null) {
/* 171 */         // update fast row
/* 172 */
/* 173 */       } else {
/* 174 */         // update unsafe row
/* 175 */
/* 176 */         // common sub-expressions
/* 177 */
/* 178 */         // evaluate aggregate function
/* 179 */         boolean agg_isNull9 = true;
/* 180 */         double agg_value10 = -1.0;
/* 181 */
/* 182 */         boolean agg_isNull11 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 183 */         double agg_value12 = agg_isNull11 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 184 */         boolean agg_isNull10 = agg_isNull11;
/* 185 */         double agg_value11 = agg_value12;
/* 186 */         if (agg_isNull10) {
/* 187 */           boolean agg_isNull12 = false;
/* 188 */           double agg_value13 = -1.0;
/* 189 */           if (!false) {
/* 190 */             agg_value13 = (double) 0;
/* 191 */           }
/* 192 */           if (!agg_isNull12) {
/* 193 */             agg_isNull10 = false;
/* 194 */             agg_value11 = agg_value13;
/* 195 */           }
/* 196 */         }
/* 197 */
/* 198 */         if (!inputadapter_isNull2) {
/* 199 */           agg_isNull9 = false; // resultCode could change nullability.
/* 200 */           agg_value10 = agg_value11 + inputadapter_value2;
/* 201 */
/* 202 */         }
/* 203 */         boolean agg_isNull8 = agg_isNull9;
/* 204 */         double agg_value9 = agg_value10;
/* 205 */         if (agg_isNull8) {
/* 206 */           boolean agg_isNull15 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 207 */           double agg_value16 = agg_isNull15 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 208 */           if (!agg_isNull15) {
/* 209 */             agg_isNull8 = false;
/* 210 */             agg_value9 = agg_value16;
/* 211 */           }
/* 212 */         }
/* 213 */         // update unsafe row buffer
/* 214 */         if (!agg_isNull8) {
/* 215 */           agg_unsafeRowAggBuffer.setDouble(0, agg_value9);
/* 216 */         } else {
/* 217 */           agg_unsafeRowAggBuffer.setNullAt(0);
/* 218 */         }
/* 219 */
/* 220 */       }
/* 221 */       if (shouldStop()) return;
/* 222 */     }
/* 223 */
/* 224 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 225 */   }
/* 226 */
/* 227 */   private void wholestagecodegen_init_2() {
/* 228 */     bhj_relation1 = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast1.value()).asReadOnlyCopy();
/* 229 */     incPeakExecutionMemory(bhj_relation1.estimatedSize());
/* 230 */
/* 231 */     this.bhj_numOutputRows1 = (org.apache.spark.sql.execution.metric.SQLMetric) references[7];
/* 232 */     bhj_result1 = new UnsafeRow(3);
/* 233 */     this.bhj_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result1, 0);
/* 234 */     this.bhj_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder1, 3);
/* 235 */     project_result1 = new UnsafeRow(1);
/* 236 */     this.project_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result1, 0);
/* 237 */     this.project_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder1, 1);
/* 238 */     this.bhj_broadcast2 = (org.apache.spark.broadcast.TorrentBroadcast) references[8];
/* 239 */
/* 240 */     bhj_relation2 = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast2.value()).asReadOnlyCopy();
/* 241 */     incPeakExecutionMemory(bhj_relation2.estimatedSize());
/* 242 */
/* 243 */   }
/* 244 */
/* 245 */   private void wholestagecodegen_init_1() {
/* 246 */     this.filter_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(filter_holder, 3);
/* 247 */     this.bhj_broadcast = (org.apache.spark.broadcast.TorrentBroadcast) references[4];
/* 248 */
/* 249 */     bhj_relation = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast.value()).asReadOnlyCopy();
/* 250 */     incPeakExecutionMemory(bhj_relation.estimatedSize());
/* 251 */
/* 252 */     this.bhj_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[5];
/* 253 */     bhj_result = new UnsafeRow(5);
/* 254 */     this.bhj_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result, 0);
/* 255 */     this.bhj_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder, 5);
/* 256 */     project_result = new UnsafeRow(2);
/* 257 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 0);
/* 258 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 2);
/* 259 */     this.bhj_broadcast1 = (org.apache.spark.broadcast.TorrentBroadcast) references[6];
/* 260 */
/* 261 */   }
/* 262 */
/* 263 */   protected void processNext() throws java.io.IOException {
/* 264 */     if (!agg_initAgg) {
/* 265 */       agg_initAgg = true;
/* 266 */       long wholestagecodegen_beforeAgg = System.nanoTime();
/* 267 */       agg_doAggregateWithKeys();
/* 268 */       wholestagecodegen_aggTime.add((System.nanoTime() - wholestagecodegen_beforeAgg) / 1000000);
/* 269 */     }
/* 270 */
/* 271 */     // output the result
/* 272 */
/* 273 */     while (agg_mapIter.next()) {
/* 274 */       wholestagecodegen_numOutputRows.add(1);
/* 275 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter.getKey();
/* 276 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter.getValue();
/* 277 */
/* 278 */       boolean agg_isNull16 = agg_aggKey.isNullAt(0);
/* 279 */       long agg_value17 = agg_isNull16 ? -1L : (agg_aggKey.getLong(0));
/* 280 */       boolean agg_isNull17 = agg_aggKey.isNullAt(1);
/* 281 */       long agg_value18 = agg_isNull17 ? -1L : (agg_aggKey.getLong(1));
/* 282 */       boolean agg_isNull18 = agg_aggBuffer.isNullAt(0);
/* 283 */       double agg_value19 = agg_isNull18 ? -1.0 : (agg_aggBuffer.getDouble(0));
/* 284 */
/* 285 */       if (!(!(agg_isNull18))) continue;
/* 286 */
/* 287 */       filter_numOutputRows.add(1);
/* 288 */
/* 289 */       // generate join key for stream side
/* 290 */
/* 291 */       // find matches from HashedRelation
/* 292 */       UnsafeRow bhj_matched = agg_isNull17 ? null: (UnsafeRow)bhj_relation.getValue(agg_value18);
/* 293 */       if (bhj_matched == null) continue;
/* 294 */
/* 295 */       double bhj_value1 = bhj_matched.getDouble(0);
/* 296 */
/* 297 */       boolean bhj_isNull3 = false;
/* 298 */
/* 299 */       boolean bhj_value3 = false;
/* 300 */       bhj_value3 = org.apache.spark.util.Utils.nanSafeCompareDoubles(agg_value19, bhj_value1) > 0;
/* 301 */       if (false || !bhj_value3) continue;
/* 302 */
/* 303 */       bhj_numOutputRows.add(1);
/* 304 */
/* 305 */       // generate join key for stream side
/* 306 */
/* 307 */       // find matches from HashedRelation
/* 308 */       UnsafeRow bhj_matched1 = agg_isNull17 ? null: (UnsafeRow)bhj_relation1.getValue(agg_value18);
/* 309 */       if (bhj_matched1 == null) continue;
/* 310 */
/* 311 */       bhj_numOutputRows1.add(1);
/* 312 */
/* 313 */       // generate join key for stream side
/* 314 */
/* 315 */       // find matches from HashedRelation
/* 316 */       UnsafeRow bhj_matched2 = agg_isNull16 ? null: (UnsafeRow)bhj_relation2.getValue(agg_value17);
/* 317 */       if (bhj_matched2 == null) continue;
/* 318 */
/* 319 */       bhj_numOutputRows2.add(1);
/* 320 */
/* 321 */       boolean bhj_isNull18 = bhj_matched2.isNullAt(1);
/* 322 */       UTF8String bhj_value18 = bhj_isNull18 ? null : (bhj_matched2.getUTF8String(1));
/* 323 */       project_holder2.reset();
/* 324 */
/* 325 */       project_rowWriter2.zeroOutNullBytes();
/* 326 */
/* 327 */       if (bhj_isNull18) {
/* 328 */         project_rowWriter2.setNullAt(0);
/* 329 */       } else {
/* 330 */         project_rowWriter2.write(0, bhj_value18);
/* 331 */       }
/* 332 */       project_result2.setTotalSize(project_holder2.totalSize());
/* 333 */       append(project_result2);
/* 334 */
/* 335 */       if (shouldStop()) return;
/* 336 */     }
/* 337 */
/* 338 */     agg_mapIter.close();
/* 339 */     if (agg_sorter == null) {
/* 340 */       agg_hashMap.free();
/* 341 */     }
/* 342 */   }
/* 343 */ }
