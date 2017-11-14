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
/* 011 */   private boolean agg_bufIsNull1;
/* 012 */   private long agg_bufValue1;
/* 013 */   private org.apache.spark.sql.execution.aggregate.HashAggregateExec agg_plan;
/* 014 */   private org.apache.spark.sql.execution.UnsafeFixedWidthAggregationMap agg_hashMap;
/* 015 */   private org.apache.spark.sql.execution.UnsafeKVExternalSorter agg_sorter;
/* 016 */   private org.apache.spark.unsafe.KVIterator agg_mapIter;
/* 017 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_peakMemory;
/* 018 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_spillSize;
/* 019 */   private scala.collection.Iterator inputadapter_input;
/* 020 */   private UnsafeRow agg_result;
/* 021 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder;
/* 022 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter;
/* 023 */   private int agg_value15;
/* 024 */   private UnsafeRow agg_result1;
/* 025 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder1;
/* 026 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter1;
/* 027 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_numOutputRows;
/* 028 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_aggTime;
/* 029 */
/* 030 */   public GeneratedIterator(Object[] references) {
/* 031 */     this.references = references;
/* 032 */   }
/* 033 */
/* 034 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 035 */     partitionIndex = index;
/* 036 */     this.inputs = inputs;
/* 037 */     agg_initAgg = false;
/* 038 */
/* 039 */     this.agg_plan = (org.apache.spark.sql.execution.aggregate.HashAggregateExec) references[0];
/* 040 */
/* 041 */     this.agg_peakMemory = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 042 */     this.agg_spillSize = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 043 */     inputadapter_input = inputs[0];
/* 044 */     agg_result = new UnsafeRow(5);
/* 045 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result, 128);
/* 046 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 5);
/* 047 */
/* 048 */     agg_result1 = new UnsafeRow(5);
/* 049 */     this.agg_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result1, 128);
/* 050 */     this.agg_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder1, 5);
/* 051 */     this.wholestagecodegen_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[3];
/* 052 */     this.wholestagecodegen_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[4];
/* 053 */
/* 054 */   }
/* 055 */
/* 056 */   private void agg_doAggregateWithKeys() throws java.io.IOException {
/* 057 */     agg_hashMap = agg_plan.createHashMap();
/* 058 */
/* 059 */     while (inputadapter_input.hasNext() && !stopEarly()) {
/* 060 */       InternalRow inputadapter_row = (InternalRow) inputadapter_input.next();
/* 061 */       boolean inputadapter_isNull = inputadapter_row.isNullAt(0);
/* 062 */       UTF8String inputadapter_value = inputadapter_isNull ? null : (inputadapter_row.getUTF8String(0));
/* 063 */       boolean inputadapter_isNull1 = inputadapter_row.isNullAt(1);
/* 064 */       UTF8String inputadapter_value1 = inputadapter_isNull1 ? null : (inputadapter_row.getUTF8String(1));
/* 065 */       boolean inputadapter_isNull2 = inputadapter_row.isNullAt(2);
/* 066 */       UTF8String inputadapter_value2 = inputadapter_isNull2 ? null : (inputadapter_row.getUTF8String(2));
/* 067 */       boolean inputadapter_isNull3 = inputadapter_row.isNullAt(3);
/* 068 */       UTF8String inputadapter_value3 = inputadapter_isNull3 ? null : (inputadapter_row.getUTF8String(3));
/* 069 */       int inputadapter_value4 = inputadapter_row.getInt(4);
/* 070 */       boolean inputadapter_isNull5 = inputadapter_row.isNullAt(5);
/* 071 */       double inputadapter_value5 = inputadapter_isNull5 ? -1.0 : (inputadapter_row.getDouble(5));
/* 072 */       boolean inputadapter_isNull6 = inputadapter_row.isNullAt(6);
/* 073 */       long inputadapter_value6 = inputadapter_isNull6 ? -1L : (inputadapter_row.getLong(6));
/* 074 */
/* 075 */       UnsafeRow agg_unsafeRowAggBuffer = null;
/* 076 */
/* 077 */       UnsafeRow agg_fastAggBuffer = null;
/* 078 */
/* 079 */       if (agg_fastAggBuffer == null) {
/* 080 */         // generate grouping key
/* 081 */         agg_holder.reset();
/* 082 */
/* 083 */         agg_rowWriter.zeroOutNullBytes();
/* 084 */
/* 085 */         if (inputadapter_isNull) {
/* 086 */           agg_rowWriter.setNullAt(0);
/* 087 */         } else {
/* 088 */           agg_rowWriter.write(0, inputadapter_value);
/* 089 */         }
/* 090 */
/* 091 */         if (inputadapter_isNull1) {
/* 092 */           agg_rowWriter.setNullAt(1);
/* 093 */         } else {
/* 094 */           agg_rowWriter.write(1, inputadapter_value1);
/* 095 */         }
/* 096 */
/* 097 */         if (inputadapter_isNull2) {
/* 098 */           agg_rowWriter.setNullAt(2);
/* 099 */         } else {
/* 100 */           agg_rowWriter.write(2, inputadapter_value2);
/* 101 */         }
/* 102 */
/* 103 */         if (inputadapter_isNull3) {
/* 104 */           agg_rowWriter.setNullAt(3);
/* 105 */         } else {
/* 106 */           agg_rowWriter.write(3, inputadapter_value3);
/* 107 */         }
/* 108 */
/* 109 */         agg_rowWriter.write(4, inputadapter_value4);
/* 110 */         agg_result.setTotalSize(agg_holder.totalSize());
/* 111 */         agg_value15 = 42;
/* 112 */
/* 113 */         if (!inputadapter_isNull) {
/* 114 */           agg_value15 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(inputadapter_value.getBaseObject(), inputadapter_value.getBaseOffset(), inputadapter_value.numBytes(), agg_value15);
/* 115 */         }
/* 116 */
/* 117 */         if (!inputadapter_isNull1) {
/* 118 */           agg_value15 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(inputadapter_value1.getBaseObject(), inputadapter_value1.getBaseOffset(), inputadapter_value1.numBytes(), agg_value15);
/* 119 */         }
/* 120 */
/* 121 */         if (!inputadapter_isNull2) {
/* 122 */           agg_value15 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(inputadapter_value2.getBaseObject(), inputadapter_value2.getBaseOffset(), inputadapter_value2.numBytes(), agg_value15);
/* 123 */         }
/* 124 */
/* 125 */         if (!inputadapter_isNull3) {
/* 126 */           agg_value15 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(inputadapter_value3.getBaseObject(), inputadapter_value3.getBaseOffset(), inputadapter_value3.numBytes(), agg_value15);
/* 127 */         }
/* 128 */
/* 129 */         agg_value15 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(inputadapter_value4, agg_value15);
/* 130 */         if (true) {
/* 131 */           // try to get the buffer from hash map
/* 132 */           agg_unsafeRowAggBuffer =
/* 133 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result, agg_value15);
/* 134 */         }
/* 135 */         if (agg_unsafeRowAggBuffer == null) {
/* 136 */           if (agg_sorter == null) {
/* 137 */             agg_sorter = agg_hashMap.destructAndCreateExternalSorter();
/* 138 */           } else {
/* 139 */             agg_sorter.merge(agg_hashMap.destructAndCreateExternalSorter());
/* 140 */           }
/* 141 */
/* 142 */           // the hash map had be spilled, it should have enough memory now,
/* 143 */           // try  to allocate buffer again.
/* 144 */           agg_unsafeRowAggBuffer =
/* 145 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result, agg_value15);
/* 146 */           if (agg_unsafeRowAggBuffer == null) {
/* 147 */             // failed to allocate the first page
/* 148 */             throw new OutOfMemoryError("No enough memory for aggregation");
/* 149 */           }
/* 150 */         }
/* 151 */       }
/* 152 */
/* 153 */       if (agg_fastAggBuffer != null) {
/* 154 */         // update fast row
/* 155 */
/* 156 */       } else {
/* 157 */         // update unsafe row
/* 158 */
/* 159 */         // common sub-expressions
/* 160 */
/* 161 */         // evaluate aggregate function
/* 162 */         boolean agg_isNull19 = true;
/* 163 */         double agg_value21 = -1.0;
/* 164 */
/* 165 */         boolean agg_isNull20 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 166 */         double agg_value22 = agg_isNull20 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 167 */         if (!agg_isNull20) {
/* 168 */           if (!inputadapter_isNull5) {
/* 169 */             agg_isNull19 = false; // resultCode could change nullability.
/* 170 */             agg_value21 = agg_value22 + inputadapter_value5;
/* 171 */
/* 172 */           }
/* 173 */
/* 174 */         }
/* 175 */         boolean agg_isNull22 = true;
/* 176 */         long agg_value24 = -1L;
/* 177 */
/* 178 */         boolean agg_isNull23 = agg_unsafeRowAggBuffer.isNullAt(1);
/* 179 */         long agg_value25 = agg_isNull23 ? -1L : (agg_unsafeRowAggBuffer.getLong(1));
/* 180 */         if (!agg_isNull23) {
/* 181 */           if (!inputadapter_isNull6) {
/* 182 */             agg_isNull22 = false; // resultCode could change nullability.
/* 183 */             agg_value24 = agg_value25 + inputadapter_value6;
/* 184 */
/* 185 */           }
/* 186 */
/* 187 */         }
/* 188 */         // update unsafe row buffer
/* 189 */         if (!agg_isNull19) {
/* 190 */           agg_unsafeRowAggBuffer.setDouble(0, agg_value21);
/* 191 */         } else {
/* 192 */           agg_unsafeRowAggBuffer.setNullAt(0);
/* 193 */         }
/* 194 */
/* 195 */         if (!agg_isNull22) {
/* 196 */           agg_unsafeRowAggBuffer.setLong(1, agg_value24);
/* 197 */         } else {
/* 198 */           agg_unsafeRowAggBuffer.setNullAt(1);
/* 199 */         }
/* 200 */
/* 201 */       }
/* 202 */       if (shouldStop()) return;
/* 203 */     }
/* 204 */
/* 205 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 206 */   }
/* 207 */
/* 208 */   protected void processNext() throws java.io.IOException {
/* 209 */     if (!agg_initAgg) {
/* 210 */       agg_initAgg = true;
/* 211 */       long wholestagecodegen_beforeAgg = System.nanoTime();
/* 212 */       agg_doAggregateWithKeys();
/* 213 */       wholestagecodegen_aggTime.add((System.nanoTime() - wholestagecodegen_beforeAgg) / 1000000);
/* 214 */     }
/* 215 */
/* 216 */     // output the result
/* 217 */
/* 218 */     while (agg_mapIter.next()) {
/* 219 */       wholestagecodegen_numOutputRows.add(1);
/* 220 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter.getKey();
/* 221 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter.getValue();
/* 222 */
/* 223 */       boolean agg_isNull25 = agg_aggKey.isNullAt(0);
/* 224 */       UTF8String agg_value27 = agg_isNull25 ? null : (agg_aggKey.getUTF8String(0));
/* 225 */       boolean agg_isNull26 = agg_aggKey.isNullAt(1);
/* 226 */       UTF8String agg_value28 = agg_isNull26 ? null : (agg_aggKey.getUTF8String(1));
/* 227 */       boolean agg_isNull27 = agg_aggKey.isNullAt(2);
/* 228 */       UTF8String agg_value29 = agg_isNull27 ? null : (agg_aggKey.getUTF8String(2));
/* 229 */       boolean agg_isNull28 = agg_aggKey.isNullAt(3);
/* 230 */       UTF8String agg_value30 = agg_isNull28 ? null : (agg_aggKey.getUTF8String(3));
/* 231 */       int agg_value31 = agg_aggKey.getInt(4);
/* 232 */       boolean agg_isNull30 = agg_aggBuffer.isNullAt(0);
/* 233 */       double agg_value32 = agg_isNull30 ? -1.0 : (agg_aggBuffer.getDouble(0));
/* 234 */       boolean agg_isNull31 = agg_aggBuffer.isNullAt(1);
/* 235 */       long agg_value33 = agg_isNull31 ? -1L : (agg_aggBuffer.getLong(1));
/* 236 */       boolean agg_isNull34 = agg_isNull31;
/* 237 */       double agg_value36 = -1.0;
/* 238 */       if (!agg_isNull31) {
/* 239 */         agg_value36 = (double) agg_value33;
/* 240 */       }
/* 241 */       boolean agg_isNull32 = false;
/* 242 */       double agg_value34 = -1.0;
/* 243 */       if (agg_isNull34 || agg_value36 == 0) {
/* 244 */         agg_isNull32 = true;
/* 245 */       } else {
/* 246 */         if (agg_isNull30) {
/* 247 */           agg_isNull32 = true;
/* 248 */         } else {
/* 249 */           agg_value34 = (double)(agg_value32 / agg_value36);
/* 250 */         }
/* 251 */       }
/* 252 */
/* 253 */       agg_holder1.reset();
/* 254 */
/* 255 */       agg_rowWriter1.zeroOutNullBytes();
/* 256 */
/* 257 */       if (agg_isNull25) {
/* 258 */         agg_rowWriter1.setNullAt(0);
/* 259 */       } else {
/* 260 */         agg_rowWriter1.write(0, agg_value27);
/* 261 */       }
/* 262 */
/* 263 */       if (agg_isNull26) {
/* 264 */         agg_rowWriter1.setNullAt(1);
/* 265 */       } else {
/* 266 */         agg_rowWriter1.write(1, agg_value28);
/* 267 */       }
/* 268 */
/* 269 */       if (agg_isNull27) {
/* 270 */         agg_rowWriter1.setNullAt(2);
/* 271 */       } else {
/* 272 */         agg_rowWriter1.write(2, agg_value29);
/* 273 */       }
/* 274 */
/* 275 */       if (agg_isNull28) {
/* 276 */         agg_rowWriter1.setNullAt(3);
/* 277 */       } else {
/* 278 */         agg_rowWriter1.write(3, agg_value30);
/* 279 */       }
/* 280 */
/* 281 */       if (agg_isNull32) {
/* 282 */         agg_rowWriter1.setNullAt(4);
/* 283 */       } else {
/* 284 */         agg_rowWriter1.write(4, agg_value34);
/* 285 */       }
/* 286 */       agg_result1.setTotalSize(agg_holder1.totalSize());
/* 287 */       append(agg_result1);
/* 288 */
/* 289 */       if (shouldStop()) return;
/* 290 */     }
/* 291 */
/* 292 */     agg_mapIter.close();
/* 293 */     if (agg_sorter == null) {
/* 294 */       agg_hashMap.free();
/* 295 */     }
/* 296 */   }
/* 297 */ }
