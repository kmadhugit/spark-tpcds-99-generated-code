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
/* 015 */   private scala.collection.Iterator smj_leftInput;
/* 016 */   private scala.collection.Iterator smj_rightInput;
/* 017 */   private InternalRow smj_leftRow;
/* 018 */   private InternalRow smj_rightRow;
/* 019 */   private int smj_value2;
/* 020 */   private org.apache.spark.sql.execution.ExternalAppendOnlyUnsafeRowArray smj_matches;
/* 021 */   private int smj_value3;
/* 022 */   private int smj_value4;
/* 023 */   private boolean smj_isNull2;
/* 024 */   private UTF8String smj_value5;
/* 025 */   private boolean smj_isNull3;
/* 026 */   private org.apache.spark.sql.execution.metric.SQLMetric smj_numOutputRows;
/* 027 */   private UnsafeRow smj_result;
/* 028 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder smj_holder;
/* 029 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter smj_rowWriter;
/* 030 */   private UnsafeRow project_result;
/* 031 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder;
/* 032 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter;
/* 033 */   private UnsafeRow agg_result;
/* 034 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder;
/* 035 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter;
/* 036 */   private int agg_value6;
/* 037 */   private UnsafeRow agg_result1;
/* 038 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder1;
/* 039 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter1;
/* 040 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_numOutputRows;
/* 041 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_aggTime;
/* 042 */
/* 043 */   public GeneratedIterator(Object[] references) {
/* 044 */     this.references = references;
/* 045 */   }
/* 046 */
/* 047 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 048 */     partitionIndex = index;
/* 049 */     this.inputs = inputs;
/* 050 */     wholestagecodegen_init_0();
/* 051 */     wholestagecodegen_init_1();
/* 052 */
/* 053 */   }
/* 054 */
/* 055 */   private void wholestagecodegen_init_0() {
/* 056 */     agg_initAgg = false;
/* 057 */     this.agg_plan = (org.apache.spark.sql.execution.aggregate.HashAggregateExec) references[0];
/* 058 */
/* 059 */     this.agg_peakMemory = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 060 */     this.agg_spillSize = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 061 */     smj_leftInput = inputs[0];
/* 062 */     smj_rightInput = inputs[1];
/* 063 */
/* 064 */     smj_rightRow = null;
/* 065 */
/* 066 */     smj_matches = new org.apache.spark.sql.execution.ExternalAppendOnlyUnsafeRowArray(2147483647);
/* 067 */
/* 068 */     this.smj_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[3];
/* 069 */     smj_result = new UnsafeRow(5);
/* 070 */     this.smj_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(smj_result, 96);
/* 071 */     this.smj_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(smj_holder, 5);
/* 072 */     project_result = new UnsafeRow(3);
/* 073 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 96);
/* 074 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 3);
/* 075 */
/* 076 */   }
/* 077 */
/* 078 */   private void agg_doAggregateWithKeys() throws java.io.IOException {
/* 079 */     agg_hashMap = agg_plan.createHashMap();
/* 080 */
/* 081 */     while (findNextInnerJoinRows(smj_leftInput, smj_rightInput)) {
/* 082 */       smj_isNull2 = smj_leftRow.isNullAt(0);
/* 083 */       smj_value4 = smj_isNull2 ? -1 : (smj_leftRow.getInt(0));
/* 084 */       smj_isNull3 = smj_leftRow.isNullAt(1);
/* 085 */       smj_value5 = smj_isNull3 ? null : (smj_leftRow.getUTF8String(1));
/* 086 */       scala.collection.Iterator<UnsafeRow> smj_iterator = smj_matches.generateIterator();
/* 087 */       while (smj_iterator.hasNext()) {
/* 088 */         InternalRow smj_rightRow1 = (InternalRow) smj_iterator.next();
/* 089 */
/* 090 */         smj_numOutputRows.add(1);
/* 091 */
/* 092 */         boolean smj_isNull6 = smj_rightRow1.isNullAt(2);
/* 093 */         UTF8String smj_value8 = smj_isNull6 ? null : (smj_rightRow1.getUTF8String(2));
/* 094 */         boolean smj_isNull5 = smj_rightRow1.isNullAt(1);
/* 095 */         UTF8String smj_value7 = smj_isNull5 ? null : (smj_rightRow1.getUTF8String(1));
/* 096 */
/* 097 */         UnsafeRow agg_unsafeRowAggBuffer = null;
/* 098 */
/* 099 */         UnsafeRow agg_fastAggBuffer = null;
/* 100 */
/* 101 */         if (agg_fastAggBuffer == null) {
/* 102 */           // generate grouping key
/* 103 */           agg_holder.reset();
/* 104 */
/* 105 */           agg_rowWriter.zeroOutNullBytes();
/* 106 */
/* 107 */           if (smj_isNull6) {
/* 108 */             agg_rowWriter.setNullAt(0);
/* 109 */           } else {
/* 110 */             agg_rowWriter.write(0, smj_value8);
/* 111 */           }
/* 112 */
/* 113 */           if (smj_isNull5) {
/* 114 */             agg_rowWriter.setNullAt(1);
/* 115 */           } else {
/* 116 */             agg_rowWriter.write(1, smj_value7);
/* 117 */           }
/* 118 */
/* 119 */           if (smj_isNull3) {
/* 120 */             agg_rowWriter.setNullAt(2);
/* 121 */           } else {
/* 122 */             agg_rowWriter.write(2, smj_value5);
/* 123 */           }
/* 124 */           agg_result.setTotalSize(agg_holder.totalSize());
/* 125 */           agg_value6 = 42;
/* 126 */
/* 127 */           if (!smj_isNull6) {
/* 128 */             agg_value6 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(smj_value8.getBaseObject(), smj_value8.getBaseOffset(), smj_value8.numBytes(), agg_value6);
/* 129 */           }
/* 130 */
/* 131 */           if (!smj_isNull5) {
/* 132 */             agg_value6 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(smj_value7.getBaseObject(), smj_value7.getBaseOffset(), smj_value7.numBytes(), agg_value6);
/* 133 */           }
/* 134 */
/* 135 */           if (!smj_isNull3) {
/* 136 */             agg_value6 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(smj_value5.getBaseObject(), smj_value5.getBaseOffset(), smj_value5.numBytes(), agg_value6);
/* 137 */           }
/* 138 */           if (true) {
/* 139 */             // try to get the buffer from hash map
/* 140 */             agg_unsafeRowAggBuffer =
/* 141 */             agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result, agg_value6);
/* 142 */           }
/* 143 */           if (agg_unsafeRowAggBuffer == null) {
/* 144 */             if (agg_sorter == null) {
/* 145 */               agg_sorter = agg_hashMap.destructAndCreateExternalSorter();
/* 146 */             } else {
/* 147 */               agg_sorter.merge(agg_hashMap.destructAndCreateExternalSorter());
/* 148 */             }
/* 149 */
/* 150 */             // the hash map had be spilled, it should have enough memory now,
/* 151 */             // try  to allocate buffer again.
/* 152 */             agg_unsafeRowAggBuffer =
/* 153 */             agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result, agg_value6);
/* 154 */             if (agg_unsafeRowAggBuffer == null) {
/* 155 */               // failed to allocate the first page
/* 156 */               throw new OutOfMemoryError("No enough memory for aggregation");
/* 157 */             }
/* 158 */           }
/* 159 */         }
/* 160 */
/* 161 */         if (agg_fastAggBuffer != null) {
/* 162 */           // update fast row
/* 163 */
/* 164 */         } else {
/* 165 */           // update unsafe row
/* 166 */
/* 167 */           // common sub-expressions
/* 168 */
/* 169 */           // evaluate aggregate function
/* 170 */
/* 171 */           // update unsafe row buffer
/* 172 */
/* 173 */         }
/* 174 */
/* 175 */       }
/* 176 */       if (shouldStop()) return;
/* 177 */     }
/* 178 */
/* 179 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 180 */   }
/* 181 */
/* 182 */   private boolean findNextInnerJoinRows(
/* 183 */     scala.collection.Iterator leftIter,
/* 184 */     scala.collection.Iterator rightIter) {
/* 185 */     smj_leftRow = null;
/* 186 */     int comp = 0;
/* 187 */     while (smj_leftRow == null) {
/* 188 */       if (!leftIter.hasNext()) return false;
/* 189 */       smj_leftRow = (InternalRow) leftIter.next();
/* 190 */
/* 191 */       boolean smj_isNull = smj_leftRow.isNullAt(0);
/* 192 */       int smj_value = smj_isNull ? -1 : (smj_leftRow.getInt(0));
/* 193 */       if (smj_isNull) {
/* 194 */         smj_leftRow = null;
/* 195 */         continue;
/* 196 */       }
/* 197 */       if (!smj_matches.isEmpty()) {
/* 198 */         comp = 0;
/* 199 */         if (comp == 0) {
/* 200 */           comp = (smj_value > smj_value3 ? 1 : smj_value < smj_value3 ? -1 : 0);
/* 201 */         }
/* 202 */
/* 203 */         if (comp == 0) {
/* 204 */           return true;
/* 205 */         }
/* 206 */         smj_matches.clear();
/* 207 */       }
/* 208 */
/* 209 */       do {
/* 210 */         if (smj_rightRow == null) {
/* 211 */           if (!rightIter.hasNext()) {
/* 212 */             smj_value3 = smj_value;
/* 213 */             return !smj_matches.isEmpty();
/* 214 */           }
/* 215 */           smj_rightRow = (InternalRow) rightIter.next();
/* 216 */
/* 217 */           boolean smj_isNull1 = smj_rightRow.isNullAt(0);
/* 218 */           int smj_value1 = smj_isNull1 ? -1 : (smj_rightRow.getInt(0));
/* 219 */           if (smj_isNull1) {
/* 220 */             smj_rightRow = null;
/* 221 */             continue;
/* 222 */           }
/* 223 */           smj_value2 = smj_value1;
/* 224 */         }
/* 225 */
/* 226 */         comp = 0;
/* 227 */         if (comp == 0) {
/* 228 */           comp = (smj_value > smj_value2 ? 1 : smj_value < smj_value2 ? -1 : 0);
/* 229 */         }
/* 230 */
/* 231 */         if (comp > 0) {
/* 232 */           smj_rightRow = null;
/* 233 */         } else if (comp < 0) {
/* 234 */           if (!smj_matches.isEmpty()) {
/* 235 */             smj_value3 = smj_value;
/* 236 */             return true;
/* 237 */           }
/* 238 */           smj_leftRow = null;
/* 239 */         } else {
/* 240 */           smj_matches.add((UnsafeRow) smj_rightRow);
/* 241 */           smj_rightRow = null;;
/* 242 */         }
/* 243 */       } while (smj_leftRow != null);
/* 244 */     }
/* 245 */     return false; // unreachable
/* 246 */   }
/* 247 */
/* 248 */   private void wholestagecodegen_init_1() {
/* 249 */     agg_result = new UnsafeRow(3);
/* 250 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result, 96);
/* 251 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 3);
/* 252 */
/* 253 */     agg_result1 = new UnsafeRow(3);
/* 254 */     this.agg_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result1, 96);
/* 255 */     this.agg_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder1, 3);
/* 256 */     this.wholestagecodegen_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[4];
/* 257 */     this.wholestagecodegen_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[5];
/* 258 */
/* 259 */   }
/* 260 */
/* 261 */   protected void processNext() throws java.io.IOException {
/* 262 */     if (!agg_initAgg) {
/* 263 */       agg_initAgg = true;
/* 264 */       long wholestagecodegen_beforeAgg = System.nanoTime();
/* 265 */       agg_doAggregateWithKeys();
/* 266 */       wholestagecodegen_aggTime.add((System.nanoTime() - wholestagecodegen_beforeAgg) / 1000000);
/* 267 */     }
/* 268 */
/* 269 */     // output the result
/* 270 */
/* 271 */     while (agg_mapIter.next()) {
/* 272 */       wholestagecodegen_numOutputRows.add(1);
/* 273 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter.getKey();
/* 274 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter.getValue();
/* 275 */
/* 276 */       boolean agg_isNull10 = agg_aggKey.isNullAt(0);
/* 277 */       UTF8String agg_value10 = agg_isNull10 ? null : (agg_aggKey.getUTF8String(0));
/* 278 */       boolean agg_isNull11 = agg_aggKey.isNullAt(1);
/* 279 */       UTF8String agg_value11 = agg_isNull11 ? null : (agg_aggKey.getUTF8String(1));
/* 280 */       boolean agg_isNull12 = agg_aggKey.isNullAt(2);
/* 281 */       UTF8String agg_value12 = agg_isNull12 ? null : (agg_aggKey.getUTF8String(2));
/* 282 */       agg_holder1.reset();
/* 283 */
/* 284 */       agg_rowWriter1.zeroOutNullBytes();
/* 285 */
/* 286 */       if (agg_isNull10) {
/* 287 */         agg_rowWriter1.setNullAt(0);
/* 288 */       } else {
/* 289 */         agg_rowWriter1.write(0, agg_value10);
/* 290 */       }
/* 291 */
/* 292 */       if (agg_isNull11) {
/* 293 */         agg_rowWriter1.setNullAt(1);
/* 294 */       } else {
/* 295 */         agg_rowWriter1.write(1, agg_value11);
/* 296 */       }
/* 297 */
/* 298 */       if (agg_isNull12) {
/* 299 */         agg_rowWriter1.setNullAt(2);
/* 300 */       } else {
/* 301 */         agg_rowWriter1.write(2, agg_value12);
/* 302 */       }
/* 303 */       agg_result1.setTotalSize(agg_holder1.totalSize());
/* 304 */       append(agg_result1.copy());
/* 305 */
/* 306 */       if (shouldStop()) return;
/* 307 */     }
/* 308 */
/* 309 */     agg_mapIter.close();
/* 310 */     if (agg_sorter == null) {
/* 311 */       agg_hashMap.free();
/* 312 */     }
/* 313 */   }
/* 314 */ }
