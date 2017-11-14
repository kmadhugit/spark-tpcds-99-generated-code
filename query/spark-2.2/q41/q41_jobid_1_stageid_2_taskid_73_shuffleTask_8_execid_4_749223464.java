/* 001 */ public Object generate(Object[] references) {
/* 002 */   return new GeneratedIterator(references);
/* 003 */ }
/* 004 */
/* 005 */ final class GeneratedIterator extends org.apache.spark.sql.execution.BufferedRowIterator {
/* 006 */   private Object[] references;
/* 007 */   private scala.collection.Iterator[] inputs;
/* 008 */   private boolean agg_initAgg;
/* 009 */   private org.apache.spark.sql.execution.aggregate.HashAggregateExec agg_plan;
/* 010 */   private org.apache.spark.sql.execution.UnsafeFixedWidthAggregationMap agg_hashMap;
/* 011 */   private org.apache.spark.sql.execution.UnsafeKVExternalSorter agg_sorter;
/* 012 */   private org.apache.spark.unsafe.KVIterator agg_mapIter;
/* 013 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_peakMemory;
/* 014 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_spillSize;
/* 015 */   private scala.collection.Iterator scan_input;
/* 016 */   private org.apache.spark.sql.execution.metric.SQLMetric scan_numOutputRows;
/* 017 */   private org.apache.spark.sql.execution.metric.SQLMetric scan_scanTime;
/* 018 */   private long scan_scanTime1;
/* 019 */   private org.apache.spark.sql.execution.vectorized.ColumnarBatch scan_batch;
/* 020 */   private int scan_batchIdx;
/* 021 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance0;
/* 022 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance1;
/* 023 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance2;
/* 024 */   private UnsafeRow scan_result;
/* 025 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder scan_holder;
/* 026 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter scan_rowWriter;
/* 027 */   private org.apache.spark.sql.execution.metric.SQLMetric filter_numOutputRows;
/* 028 */   private UnsafeRow filter_result;
/* 029 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder filter_holder;
/* 030 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter filter_rowWriter;
/* 031 */   private UnsafeRow project_result;
/* 032 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder;
/* 033 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter;
/* 034 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast;
/* 035 */   private org.apache.spark.sql.execution.joins.UnsafeHashedRelation bhj_relation;
/* 036 */   private UnsafeRow bhj_result;
/* 037 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder;
/* 038 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter;
/* 039 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows;
/* 040 */   private UnsafeRow bhj_result1;
/* 041 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder1;
/* 042 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter1;
/* 043 */   private UnsafeRow project_result1;
/* 044 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder1;
/* 045 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter1;
/* 046 */   private UnsafeRow agg_result;
/* 047 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder;
/* 048 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter;
/* 049 */   private int agg_value2;
/* 050 */   private UnsafeRow agg_result1;
/* 051 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder1;
/* 052 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter1;
/* 053 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_numOutputRows;
/* 054 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_aggTime;
/* 055 */
/* 056 */   public GeneratedIterator(Object[] references) {
/* 057 */     this.references = references;
/* 058 */   }
/* 059 */
/* 060 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 061 */     partitionIndex = index;
/* 062 */     this.inputs = inputs;
/* 063 */     wholestagecodegen_init_0();
/* 064 */     wholestagecodegen_init_1();
/* 065 */     wholestagecodegen_init_2();
/* 066 */
/* 067 */   }
/* 068 */
/* 069 */   private void wholestagecodegen_init_0() {
/* 070 */     agg_initAgg = false;
/* 071 */     this.agg_plan = (org.apache.spark.sql.execution.aggregate.HashAggregateExec) references[0];
/* 072 */
/* 073 */     this.agg_peakMemory = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 074 */     this.agg_spillSize = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 075 */     scan_input = inputs[0];
/* 076 */     this.scan_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[3];
/* 077 */     this.scan_scanTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[4];
/* 078 */     scan_scanTime1 = 0;
/* 079 */     scan_batch = null;
/* 080 */     scan_batchIdx = 0;
/* 081 */     scan_colInstance0 = null;
/* 082 */     scan_colInstance1 = null;
/* 083 */     scan_colInstance2 = null;
/* 084 */     scan_result = new UnsafeRow(3);
/* 085 */     this.scan_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(scan_result, 64);
/* 086 */     this.scan_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(scan_holder, 3);
/* 087 */     this.filter_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[5];
/* 088 */     filter_result = new UnsafeRow(3);
/* 089 */     this.filter_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(filter_result, 64);
/* 090 */
/* 091 */   }
/* 092 */
/* 093 */   private void scan_nextBatch() throws java.io.IOException {
/* 094 */     long getBatchStart = System.nanoTime();
/* 095 */     if (scan_input.hasNext()) {
/* 096 */       scan_batch = (org.apache.spark.sql.execution.vectorized.ColumnarBatch)scan_input.next();
/* 097 */       scan_numOutputRows.add(scan_batch.numRows());
/* 098 */       scan_batchIdx = 0;
/* 099 */       scan_colInstance0 = scan_batch.column(0);
/* 100 */       scan_colInstance1 = scan_batch.column(1);
/* 101 */       scan_colInstance2 = scan_batch.column(2);
/* 102 */
/* 103 */     }
/* 104 */     scan_scanTime1 += System.nanoTime() - getBatchStart;
/* 105 */   }
/* 106 */
/* 107 */   private void agg_doAggregateWithKeys() throws java.io.IOException {
/* 108 */     agg_hashMap = agg_plan.createHashMap();
/* 109 */
/* 110 */     if (scan_batch == null) {
/* 111 */       scan_nextBatch();
/* 112 */     }
/* 113 */     while (scan_batch != null) {
/* 114 */       int scan_numRows = scan_batch.numRows();
/* 115 */       int scan_localEnd = scan_numRows - scan_batchIdx;
/* 116 */       for (int scan_localIdx = 0; scan_localIdx < scan_localEnd; scan_localIdx++) {
/* 117 */         int scan_rowIdx = scan_batchIdx + scan_localIdx;
/* 118 */         boolean scan_isNull = scan_colInstance0.isNullAt(scan_rowIdx);
/* 119 */         int scan_value = scan_isNull ? -1 : (scan_colInstance0.getInt(scan_rowIdx));
/* 120 */
/* 121 */         if (!(!(scan_isNull))) continue;
/* 122 */
/* 123 */         boolean filter_isNull2 = false;
/* 124 */
/* 125 */         boolean filter_value2 = false;
/* 126 */         filter_value2 = scan_value >= 738;
/* 127 */         if (!filter_value2) continue;
/* 128 */         boolean filter_isNull5 = false;
/* 129 */
/* 130 */         boolean filter_value5 = false;
/* 131 */         filter_value5 = scan_value <= 778;
/* 132 */         if (!filter_value5) continue;
/* 133 */
/* 134 */         boolean scan_isNull1 = scan_colInstance1.isNullAt(scan_rowIdx);
/* 135 */         UTF8String scan_value1 = scan_isNull1 ? null : (scan_colInstance1.getUTF8String(scan_rowIdx));
/* 136 */
/* 137 */         if (!(!(scan_isNull1))) continue;
/* 138 */
/* 139 */         filter_numOutputRows.add(1);
/* 140 */
/* 141 */         // generate join key for stream side
/* 142 */
/* 143 */         bhj_holder.reset();
/* 144 */
/* 145 */         bhj_rowWriter.write(0, scan_value1);
/* 146 */         bhj_result.setTotalSize(bhj_holder.totalSize());
/* 147 */
/* 148 */         // find matches from HashedRelation
/* 149 */         UnsafeRow bhj_matched = bhj_result.anyNull() ? null: (UnsafeRow)bhj_relation.getValue(bhj_result);
/* 150 */         if (bhj_matched == null) continue;
/* 151 */
/* 152 */         bhj_numOutputRows.add(1);
/* 153 */
/* 154 */         boolean scan_isNull2 = scan_colInstance2.isNullAt(scan_rowIdx);
/* 155 */         UTF8String scan_value2 = scan_isNull2 ? null : (scan_colInstance2.getUTF8String(scan_rowIdx));
/* 156 */
/* 157 */         UnsafeRow agg_unsafeRowAggBuffer = null;
/* 158 */
/* 159 */         UnsafeRow agg_fastAggBuffer = null;
/* 160 */
/* 161 */         if (agg_fastAggBuffer == null) {
/* 162 */           // generate grouping key
/* 163 */           agg_holder.reset();
/* 164 */
/* 165 */           agg_rowWriter.zeroOutNullBytes();
/* 166 */
/* 167 */           if (scan_isNull2) {
/* 168 */             agg_rowWriter.setNullAt(0);
/* 169 */           } else {
/* 170 */             agg_rowWriter.write(0, scan_value2);
/* 171 */           }
/* 172 */           agg_result.setTotalSize(agg_holder.totalSize());
/* 173 */           agg_value2 = 42;
/* 174 */
/* 175 */           if (!scan_isNull2) {
/* 176 */             agg_value2 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(scan_value2.getBaseObject(), scan_value2.getBaseOffset(), scan_value2.numBytes(), agg_value2);
/* 177 */           }
/* 178 */           if (true) {
/* 179 */             // try to get the buffer from hash map
/* 180 */             agg_unsafeRowAggBuffer =
/* 181 */             agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result, agg_value2);
/* 182 */           }
/* 183 */           if (agg_unsafeRowAggBuffer == null) {
/* 184 */             if (agg_sorter == null) {
/* 185 */               agg_sorter = agg_hashMap.destructAndCreateExternalSorter();
/* 186 */             } else {
/* 187 */               agg_sorter.merge(agg_hashMap.destructAndCreateExternalSorter());
/* 188 */             }
/* 189 */
/* 190 */             // the hash map had be spilled, it should have enough memory now,
/* 191 */             // try  to allocate buffer again.
/* 192 */             agg_unsafeRowAggBuffer =
/* 193 */             agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result, agg_value2);
/* 194 */             if (agg_unsafeRowAggBuffer == null) {
/* 195 */               // failed to allocate the first page
/* 196 */               throw new OutOfMemoryError("No enough memory for aggregation");
/* 197 */             }
/* 198 */           }
/* 199 */         }
/* 200 */
/* 201 */         if (agg_fastAggBuffer != null) {
/* 202 */           // update fast row
/* 203 */
/* 204 */         } else {
/* 205 */           // update unsafe row
/* 206 */
/* 207 */           // common sub-expressions
/* 208 */
/* 209 */           // evaluate aggregate function
/* 210 */
/* 211 */           // update unsafe row buffer
/* 212 */
/* 213 */         }
/* 214 */         // shouldStop check is eliminated
/* 215 */       }
/* 216 */       scan_batchIdx = scan_numRows;
/* 217 */       scan_batch = null;
/* 218 */       scan_nextBatch();
/* 219 */     }
/* 220 */     scan_scanTime.add(scan_scanTime1 / (1000 * 1000));
/* 221 */     scan_scanTime1 = 0;
/* 222 */
/* 223 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 224 */   }
/* 225 */
/* 226 */   private void wholestagecodegen_init_2() {
/* 227 */     this.bhj_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder1, 3);
/* 228 */     project_result1 = new UnsafeRow(1);
/* 229 */     this.project_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result1, 32);
/* 230 */     this.project_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder1, 1);
/* 231 */     agg_result = new UnsafeRow(1);
/* 232 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result, 32);
/* 233 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 1);
/* 234 */
/* 235 */     agg_result1 = new UnsafeRow(1);
/* 236 */     this.agg_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result1, 32);
/* 237 */     this.agg_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder1, 1);
/* 238 */     this.wholestagecodegen_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[8];
/* 239 */     this.wholestagecodegen_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[9];
/* 240 */
/* 241 */   }
/* 242 */
/* 243 */   private void wholestagecodegen_init_1() {
/* 244 */     this.filter_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(filter_holder, 3);
/* 245 */     project_result = new UnsafeRow(2);
/* 246 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 64);
/* 247 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 2);
/* 248 */     this.bhj_broadcast = (org.apache.spark.broadcast.TorrentBroadcast) references[6];
/* 249 */
/* 250 */     bhj_relation = ((org.apache.spark.sql.execution.joins.UnsafeHashedRelation) bhj_broadcast.value()).asReadOnlyCopy();
/* 251 */     incPeakExecutionMemory(bhj_relation.estimatedSize());
/* 252 */
/* 253 */     bhj_result = new UnsafeRow(1);
/* 254 */     this.bhj_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result, 32);
/* 255 */     this.bhj_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder, 1);
/* 256 */     this.bhj_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[7];
/* 257 */     bhj_result1 = new UnsafeRow(3);
/* 258 */     this.bhj_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result1, 96);
/* 259 */
/* 260 */   }
/* 261 */
/* 262 */   protected void processNext() throws java.io.IOException {
/* 263 */     if (!agg_initAgg) {
/* 264 */       agg_initAgg = true;
/* 265 */       long wholestagecodegen_beforeAgg = System.nanoTime();
/* 266 */       agg_doAggregateWithKeys();
/* 267 */       wholestagecodegen_aggTime.add((System.nanoTime() - wholestagecodegen_beforeAgg) / 1000000);
/* 268 */     }
/* 269 */
/* 270 */     // output the result
/* 271 */
/* 272 */     while (agg_mapIter.next()) {
/* 273 */       wholestagecodegen_numOutputRows.add(1);
/* 274 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter.getKey();
/* 275 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter.getValue();
/* 276 */
/* 277 */       boolean agg_isNull4 = agg_aggKey.isNullAt(0);
/* 278 */       UTF8String agg_value4 = agg_isNull4 ? null : (agg_aggKey.getUTF8String(0));
/* 279 */       agg_holder1.reset();
/* 280 */
/* 281 */       agg_rowWriter1.zeroOutNullBytes();
/* 282 */
/* 283 */       if (agg_isNull4) {
/* 284 */         agg_rowWriter1.setNullAt(0);
/* 285 */       } else {
/* 286 */         agg_rowWriter1.write(0, agg_value4);
/* 287 */       }
/* 288 */       agg_result1.setTotalSize(agg_holder1.totalSize());
/* 289 */       append(agg_result1);
/* 290 */
/* 291 */       if (shouldStop()) return;
/* 292 */     }
/* 293 */
/* 294 */     agg_mapIter.close();
/* 295 */     if (agg_sorter == null) {
/* 296 */       agg_hashMap.free();
/* 297 */     }
/* 298 */   }
/* 299 */ }
