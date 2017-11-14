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
/* 047 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_numOutputRows;
/* 048 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_aggTime;
/* 049 */
/* 050 */   public GeneratedIterator(Object[] references) {
/* 051 */     this.references = references;
/* 052 */   }
/* 053 */
/* 054 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 055 */     partitionIndex = index;
/* 056 */     this.inputs = inputs;
/* 057 */     wholestagecodegen_init_0();
/* 058 */     wholestagecodegen_init_1();
/* 059 */     wholestagecodegen_init_2();
/* 060 */
/* 061 */   }
/* 062 */
/* 063 */   private void wholestagecodegen_init_0() {
/* 064 */     agg_initAgg = false;
/* 065 */
/* 066 */     this.agg_plan = (org.apache.spark.sql.execution.aggregate.HashAggregateExec) references[0];
/* 067 */
/* 068 */     this.agg_peakMemory = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 069 */     this.agg_spillSize = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 070 */     inputadapter_input = inputs[0];
/* 071 */     agg_result = new UnsafeRow(2);
/* 072 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result, 0);
/* 073 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 2);
/* 074 */
/* 075 */     agg_result1 = new UnsafeRow(3);
/* 076 */     this.agg_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result1, 0);
/* 077 */     this.agg_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder1, 3);
/* 078 */     this.filter_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[3];
/* 079 */     filter_result = new UnsafeRow(3);
/* 080 */     this.filter_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(filter_result, 0);
/* 081 */
/* 082 */   }
/* 083 */
/* 084 */   private void agg_doAggregateWithKeys() throws java.io.IOException {
/* 085 */     agg_hashMap = agg_plan.createHashMap();
/* 086 */
/* 087 */     while (inputadapter_input.hasNext() && !stopEarly()) {
/* 088 */       InternalRow inputadapter_row = (InternalRow) inputadapter_input.next();
/* 089 */       boolean inputadapter_isNull = inputadapter_row.isNullAt(0);
/* 090 */       int inputadapter_value = inputadapter_isNull ? -1 : (inputadapter_row.getInt(0));
/* 091 */       boolean inputadapter_isNull1 = inputadapter_row.isNullAt(1);
/* 092 */       int inputadapter_value1 = inputadapter_isNull1 ? -1 : (inputadapter_row.getInt(1));
/* 093 */       boolean inputadapter_isNull2 = inputadapter_row.isNullAt(2);
/* 094 */       double inputadapter_value2 = inputadapter_isNull2 ? -1.0 : (inputadapter_row.getDouble(2));
/* 095 */
/* 096 */       UnsafeRow agg_unsafeRowAggBuffer = null;
/* 097 */
/* 098 */       UnsafeRow agg_fastAggBuffer = null;
/* 099 */
/* 100 */       if (agg_fastAggBuffer == null) {
/* 101 */         // generate grouping key
/* 102 */         agg_rowWriter.zeroOutNullBytes();
/* 103 */
/* 104 */         if (inputadapter_isNull) {
/* 105 */           agg_rowWriter.setNullAt(0);
/* 106 */         } else {
/* 107 */           agg_rowWriter.write(0, inputadapter_value);
/* 108 */         }
/* 109 */
/* 110 */         if (inputadapter_isNull1) {
/* 111 */           agg_rowWriter.setNullAt(1);
/* 112 */         } else {
/* 113 */           agg_rowWriter.write(1, inputadapter_value1);
/* 114 */         }
/* 115 */         agg_value6 = 42;
/* 116 */
/* 117 */         if (!inputadapter_isNull) {
/* 118 */           agg_value6 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(inputadapter_value, agg_value6);
/* 119 */         }
/* 120 */
/* 121 */         if (!inputadapter_isNull1) {
/* 122 */           agg_value6 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(inputadapter_value1, agg_value6);
/* 123 */         }
/* 124 */         if (true) {
/* 125 */           // try to get the buffer from hash map
/* 126 */           agg_unsafeRowAggBuffer =
/* 127 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result, agg_value6);
/* 128 */         }
/* 129 */         if (agg_unsafeRowAggBuffer == null) {
/* 130 */           if (agg_sorter == null) {
/* 131 */             agg_sorter = agg_hashMap.destructAndCreateExternalSorter();
/* 132 */           } else {
/* 133 */             agg_sorter.merge(agg_hashMap.destructAndCreateExternalSorter());
/* 134 */           }
/* 135 */
/* 136 */           // the hash map had be spilled, it should have enough memory now,
/* 137 */           // try  to allocate buffer again.
/* 138 */           agg_unsafeRowAggBuffer =
/* 139 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result, agg_value6);
/* 140 */           if (agg_unsafeRowAggBuffer == null) {
/* 141 */             // failed to allocate the first page
/* 142 */             throw new OutOfMemoryError("No enough memory for aggregation");
/* 143 */           }
/* 144 */         }
/* 145 */       }
/* 146 */
/* 147 */       if (agg_fastAggBuffer != null) {
/* 148 */         // update fast row
/* 149 */
/* 150 */       } else {
/* 151 */         // update unsafe row
/* 152 */
/* 153 */         // common sub-expressions
/* 154 */
/* 155 */         // evaluate aggregate function
/* 156 */         boolean agg_isNull9 = true;
/* 157 */         double agg_value10 = -1.0;
/* 158 */
/* 159 */         boolean agg_isNull11 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 160 */         double agg_value12 = agg_isNull11 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 161 */         boolean agg_isNull10 = agg_isNull11;
/* 162 */         double agg_value11 = agg_value12;
/* 163 */         if (agg_isNull10) {
/* 164 */           boolean agg_isNull12 = false;
/* 165 */           double agg_value13 = -1.0;
/* 166 */           if (!false) {
/* 167 */             agg_value13 = (double) 0;
/* 168 */           }
/* 169 */           if (!agg_isNull12) {
/* 170 */             agg_isNull10 = false;
/* 171 */             agg_value11 = agg_value13;
/* 172 */           }
/* 173 */         }
/* 174 */
/* 175 */         if (!inputadapter_isNull2) {
/* 176 */           agg_isNull9 = false; // resultCode could change nullability.
/* 177 */           agg_value10 = agg_value11 + inputadapter_value2;
/* 178 */
/* 179 */         }
/* 180 */         boolean agg_isNull8 = agg_isNull9;
/* 181 */         double agg_value9 = agg_value10;
/* 182 */         if (agg_isNull8) {
/* 183 */           boolean agg_isNull15 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 184 */           double agg_value16 = agg_isNull15 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 185 */           if (!agg_isNull15) {
/* 186 */             agg_isNull8 = false;
/* 187 */             agg_value9 = agg_value16;
/* 188 */           }
/* 189 */         }
/* 190 */         // update unsafe row buffer
/* 191 */         if (!agg_isNull8) {
/* 192 */           agg_unsafeRowAggBuffer.setDouble(0, agg_value9);
/* 193 */         } else {
/* 194 */           agg_unsafeRowAggBuffer.setNullAt(0);
/* 195 */         }
/* 196 */
/* 197 */       }
/* 198 */       if (shouldStop()) return;
/* 199 */     }
/* 200 */
/* 201 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 202 */   }
/* 203 */
/* 204 */   private void wholestagecodegen_init_2() {
/* 205 */     bhj_relation1 = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast1.value()).asReadOnlyCopy();
/* 206 */     incPeakExecutionMemory(bhj_relation1.estimatedSize());
/* 207 */
/* 208 */     this.bhj_numOutputRows1 = (org.apache.spark.sql.execution.metric.SQLMetric) references[7];
/* 209 */     bhj_result1 = new UnsafeRow(9);
/* 210 */     this.bhj_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result1, 96);
/* 211 */     this.bhj_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder1, 9);
/* 212 */     project_result1 = new UnsafeRow(7);
/* 213 */     this.project_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result1, 96);
/* 214 */     this.project_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder1, 7);
/* 215 */     this.wholestagecodegen_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[8];
/* 216 */     this.wholestagecodegen_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[9];
/* 217 */
/* 218 */   }
/* 219 */
/* 220 */   private void wholestagecodegen_init_1() {
/* 221 */     this.filter_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(filter_holder, 3);
/* 222 */     this.bhj_broadcast = (org.apache.spark.broadcast.TorrentBroadcast) references[4];
/* 223 */
/* 224 */     bhj_relation = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast.value()).asReadOnlyCopy();
/* 225 */     incPeakExecutionMemory(bhj_relation.estimatedSize());
/* 226 */
/* 227 */     this.bhj_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[5];
/* 228 */     bhj_result = new UnsafeRow(5);
/* 229 */     this.bhj_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result, 32);
/* 230 */     this.bhj_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder, 5);
/* 231 */     project_result = new UnsafeRow(4);
/* 232 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 32);
/* 233 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 4);
/* 234 */     this.bhj_broadcast1 = (org.apache.spark.broadcast.TorrentBroadcast) references[6];
/* 235 */
/* 236 */   }
/* 237 */
/* 238 */   protected void processNext() throws java.io.IOException {
/* 239 */     if (!agg_initAgg) {
/* 240 */       agg_initAgg = true;
/* 241 */       long wholestagecodegen_beforeAgg = System.nanoTime();
/* 242 */       agg_doAggregateWithKeys();
/* 243 */       wholestagecodegen_aggTime.add((System.nanoTime() - wholestagecodegen_beforeAgg) / 1000000);
/* 244 */     }
/* 245 */
/* 246 */     // output the result
/* 247 */
/* 248 */     while (agg_mapIter.next()) {
/* 249 */       wholestagecodegen_numOutputRows.add(1);
/* 250 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter.getKey();
/* 251 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter.getValue();
/* 252 */
/* 253 */       boolean agg_isNull16 = agg_aggKey.isNullAt(0);
/* 254 */       int agg_value17 = agg_isNull16 ? -1 : (agg_aggKey.getInt(0));
/* 255 */       boolean agg_isNull17 = agg_aggKey.isNullAt(1);
/* 256 */       int agg_value18 = agg_isNull17 ? -1 : (agg_aggKey.getInt(1));
/* 257 */       boolean agg_isNull18 = agg_aggBuffer.isNullAt(0);
/* 258 */       double agg_value19 = agg_isNull18 ? -1.0 : (agg_aggBuffer.getDouble(0));
/* 259 */
/* 260 */       if (!(!(agg_isNull18))) continue;
/* 261 */
/* 262 */       filter_numOutputRows.add(1);
/* 263 */
/* 264 */       // generate join key for stream side
/* 265 */
/* 266 */       boolean bhj_isNull = agg_isNull16;
/* 267 */       long bhj_value = -1L;
/* 268 */       if (!agg_isNull16) {
/* 269 */         bhj_value = (long) agg_value17;
/* 270 */       }
/* 271 */       // find matches from HashedRelation
/* 272 */       UnsafeRow bhj_matched = bhj_isNull ? null: (UnsafeRow)bhj_relation.getValue(bhj_value);
/* 273 */       if (bhj_matched == null) continue;
/* 274 */
/* 275 */       bhj_numOutputRows.add(1);
/* 276 */
/* 277 */       // generate join key for stream side
/* 278 */
/* 279 */       boolean bhj_isNull9 = agg_isNull17;
/* 280 */       long bhj_value9 = -1L;
/* 281 */       if (!agg_isNull17) {
/* 282 */         bhj_value9 = (long) agg_value18;
/* 283 */       }
/* 284 */       // find matches from HashedRelation
/* 285 */       UnsafeRow bhj_matched1 = bhj_isNull9 ? null: (UnsafeRow)bhj_relation1.getValue(bhj_value9);
/* 286 */       if (bhj_matched1 == null) continue;
/* 287 */
/* 288 */       bhj_numOutputRows1.add(1);
/* 289 */
/* 290 */       boolean bhj_isNull3 = bhj_matched.isNullAt(1);
/* 291 */       UTF8String bhj_value3 = bhj_isNull3 ? null : (bhj_matched.getUTF8String(1));
/* 292 */       boolean bhj_isNull12 = bhj_matched1.isNullAt(1);
/* 293 */       UTF8String bhj_value12 = bhj_isNull12 ? null : (bhj_matched1.getUTF8String(1));
/* 294 */       boolean bhj_isNull13 = bhj_matched1.isNullAt(2);
/* 295 */       double bhj_value13 = bhj_isNull13 ? -1.0 : (bhj_matched1.getDouble(2));
/* 296 */       boolean bhj_isNull14 = bhj_matched1.isNullAt(3);
/* 297 */       double bhj_value14 = bhj_isNull14 ? -1.0 : (bhj_matched1.getDouble(3));
/* 298 */       boolean bhj_isNull15 = bhj_matched1.isNullAt(4);
/* 299 */       UTF8String bhj_value15 = bhj_isNull15 ? null : (bhj_matched1.getUTF8String(4));
/* 300 */       project_holder1.reset();
/* 301 */
/* 302 */       project_rowWriter1.zeroOutNullBytes();
/* 303 */
/* 304 */       if (bhj_isNull3) {
/* 305 */         project_rowWriter1.setNullAt(0);
/* 306 */       } else {
/* 307 */         project_rowWriter1.write(0, bhj_value3);
/* 308 */       }
/* 309 */
/* 310 */       if (agg_isNull16) {
/* 311 */         project_rowWriter1.setNullAt(1);
/* 312 */       } else {
/* 313 */         project_rowWriter1.write(1, agg_value17);
/* 314 */       }
/* 315 */
/* 316 */       project_rowWriter1.write(2, agg_value19);
/* 317 */
/* 318 */       if (bhj_isNull12) {
/* 319 */         project_rowWriter1.setNullAt(3);
/* 320 */       } else {
/* 321 */         project_rowWriter1.write(3, bhj_value12);
/* 322 */       }
/* 323 */
/* 324 */       if (bhj_isNull13) {
/* 325 */         project_rowWriter1.setNullAt(4);
/* 326 */       } else {
/* 327 */         project_rowWriter1.write(4, bhj_value13);
/* 328 */       }
/* 329 */
/* 330 */       if (bhj_isNull14) {
/* 331 */         project_rowWriter1.setNullAt(5);
/* 332 */       } else {
/* 333 */         project_rowWriter1.write(5, bhj_value14);
/* 334 */       }
/* 335 */
/* 336 */       if (bhj_isNull15) {
/* 337 */         project_rowWriter1.setNullAt(6);
/* 338 */       } else {
/* 339 */         project_rowWriter1.write(6, bhj_value15);
/* 340 */       }
/* 341 */       project_result1.setTotalSize(project_holder1.totalSize());
/* 342 */       append(project_result1);
/* 343 */
/* 344 */       if (shouldStop()) return;
/* 345 */     }
/* 346 */
/* 347 */     agg_mapIter.close();
/* 348 */     if (agg_sorter == null) {
/* 349 */       agg_hashMap.free();
/* 350 */     }
/* 351 */   }
/* 352 */ }
