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
/* 011 */   private boolean agg_initAgg1;
/* 012 */   private boolean agg_bufIsNull1;
/* 013 */   private double agg_bufValue1;
/* 014 */   private org.apache.spark.sql.execution.aggregate.HashAggregateExec agg_plan;
/* 015 */   private org.apache.spark.sql.execution.UnsafeFixedWidthAggregationMap agg_hashMap;
/* 016 */   private org.apache.spark.sql.execution.UnsafeKVExternalSorter agg_sorter;
/* 017 */   private org.apache.spark.unsafe.KVIterator agg_mapIter;
/* 018 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_peakMemory;
/* 019 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_spillSize;
/* 020 */   private scala.collection.Iterator inputadapter_input;
/* 021 */   private UnsafeRow agg_result;
/* 022 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder;
/* 023 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter;
/* 024 */   private int agg_value5;
/* 025 */   private UnsafeRow agg_result1;
/* 026 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder1;
/* 027 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter1;
/* 028 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_numOutputRows;
/* 029 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_aggTime;
/* 030 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_numOutputRows1;
/* 031 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_aggTime1;
/* 032 */   private UnsafeRow agg_result2;
/* 033 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder2;
/* 034 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter2;
/* 035 */
/* 036 */   public GeneratedIterator(Object[] references) {
/* 037 */     this.references = references;
/* 038 */   }
/* 039 */
/* 040 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 041 */     partitionIndex = index;
/* 042 */     this.inputs = inputs;
/* 043 */     wholestagecodegen_init_0();
/* 044 */     wholestagecodegen_init_1();
/* 045 */
/* 046 */   }
/* 047 */
/* 048 */   private void wholestagecodegen_init_0() {
/* 049 */     agg_initAgg = false;
/* 050 */
/* 051 */     agg_initAgg1 = false;
/* 052 */
/* 053 */     this.agg_plan = (org.apache.spark.sql.execution.aggregate.HashAggregateExec) references[0];
/* 054 */
/* 055 */     this.agg_peakMemory = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 056 */     this.agg_spillSize = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 057 */     inputadapter_input = inputs[0];
/* 058 */     agg_result = new UnsafeRow(1);
/* 059 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result, 0);
/* 060 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 1);
/* 061 */
/* 062 */     agg_result1 = new UnsafeRow(1);
/* 063 */     this.agg_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result1, 0);
/* 064 */     this.agg_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder1, 1);
/* 065 */     this.agg_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[3];
/* 066 */     this.agg_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[4];
/* 067 */     this.agg_numOutputRows1 = (org.apache.spark.sql.execution.metric.SQLMetric) references[5];
/* 068 */
/* 069 */   }
/* 070 */
/* 071 */   private void agg_doAggregateWithoutKey() throws java.io.IOException {
/* 072 */     // initialize aggregation buffer
/* 073 */     final double agg_value = -1.0;
/* 074 */     agg_bufIsNull = true;
/* 075 */     agg_bufValue = agg_value;
/* 076 */
/* 077 */     if (!agg_initAgg1) {
/* 078 */       agg_initAgg1 = true;
/* 079 */       long agg_beforeAgg = System.nanoTime();
/* 080 */       agg_doAggregateWithKeys();
/* 081 */       agg_aggTime.add((System.nanoTime() - agg_beforeAgg) / 1000000);
/* 082 */     }
/* 083 */
/* 084 */     // output the result
/* 085 */
/* 086 */     while (agg_mapIter.next()) {
/* 087 */       agg_numOutputRows.add(1);
/* 088 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter.getKey();
/* 089 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter.getValue();
/* 090 */
/* 091 */       boolean agg_isNull14 = agg_aggKey.isNullAt(0);
/* 092 */       int agg_value15 = agg_isNull14 ? -1 : (agg_aggKey.getInt(0));
/* 093 */       boolean agg_isNull15 = agg_aggBuffer.isNullAt(0);
/* 094 */       double agg_value16 = agg_isNull15 ? -1.0 : (agg_aggBuffer.getDouble(0));
/* 095 */
/* 096 */       // do aggregate
/* 097 */       // common sub-expressions
/* 098 */
/* 099 */       // evaluate aggregate function
/* 100 */       boolean agg_isNull19 = agg_bufIsNull;
/* 101 */       double agg_value20 = agg_bufValue;
/* 102 */
/* 103 */       if (!agg_isNull15 && (agg_isNull19 ||
/* 104 */           (org.apache.spark.util.Utils.nanSafeCompareDoubles(agg_value16, agg_value20)) > 0)) {
/* 105 */         agg_isNull19 = false;
/* 106 */         agg_value20 = agg_value16;
/* 107 */       }
/* 108 */       // update aggregation buffer
/* 109 */       agg_bufIsNull = agg_isNull19;
/* 110 */       agg_bufValue = agg_value20;
/* 111 */
/* 112 */       if (shouldStop()) return;
/* 113 */     }
/* 114 */
/* 115 */     agg_mapIter.close();
/* 116 */     if (agg_sorter == null) {
/* 117 */       agg_hashMap.free();
/* 118 */     }
/* 119 */
/* 120 */   }
/* 121 */
/* 122 */   private void agg_doAggregateWithKeys() throws java.io.IOException {
/* 123 */     agg_hashMap = agg_plan.createHashMap();
/* 124 */
/* 125 */     while (inputadapter_input.hasNext() && !stopEarly()) {
/* 126 */       InternalRow inputadapter_row = (InternalRow) inputadapter_input.next();
/* 127 */       boolean inputadapter_isNull = inputadapter_row.isNullAt(0);
/* 128 */       int inputadapter_value = inputadapter_isNull ? -1 : (inputadapter_row.getInt(0));
/* 129 */       boolean inputadapter_isNull1 = inputadapter_row.isNullAt(1);
/* 130 */       double inputadapter_value1 = inputadapter_isNull1 ? -1.0 : (inputadapter_row.getDouble(1));
/* 131 */
/* 132 */       UnsafeRow agg_unsafeRowAggBuffer = null;
/* 133 */
/* 134 */       UnsafeRow agg_fastAggBuffer = null;
/* 135 */
/* 136 */       if (agg_fastAggBuffer == null) {
/* 137 */         // generate grouping key
/* 138 */         agg_rowWriter.zeroOutNullBytes();
/* 139 */
/* 140 */         if (inputadapter_isNull) {
/* 141 */           agg_rowWriter.setNullAt(0);
/* 142 */         } else {
/* 143 */           agg_rowWriter.write(0, inputadapter_value);
/* 144 */         }
/* 145 */         agg_value5 = 42;
/* 146 */
/* 147 */         if (!inputadapter_isNull) {
/* 148 */           agg_value5 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(inputadapter_value, agg_value5);
/* 149 */         }
/* 150 */         if (true) {
/* 151 */           // try to get the buffer from hash map
/* 152 */           agg_unsafeRowAggBuffer =
/* 153 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result, agg_value5);
/* 154 */         }
/* 155 */         if (agg_unsafeRowAggBuffer == null) {
/* 156 */           if (agg_sorter == null) {
/* 157 */             agg_sorter = agg_hashMap.destructAndCreateExternalSorter();
/* 158 */           } else {
/* 159 */             agg_sorter.merge(agg_hashMap.destructAndCreateExternalSorter());
/* 160 */           }
/* 161 */
/* 162 */           // the hash map had be spilled, it should have enough memory now,
/* 163 */           // try  to allocate buffer again.
/* 164 */           agg_unsafeRowAggBuffer =
/* 165 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result, agg_value5);
/* 166 */           if (agg_unsafeRowAggBuffer == null) {
/* 167 */             // failed to allocate the first page
/* 168 */             throw new OutOfMemoryError("No enough memory for aggregation");
/* 169 */           }
/* 170 */         }
/* 171 */       }
/* 172 */
/* 173 */       if (agg_fastAggBuffer != null) {
/* 174 */         // update fast row
/* 175 */
/* 176 */       } else {
/* 177 */         // update unsafe row
/* 178 */
/* 179 */         // common sub-expressions
/* 180 */
/* 181 */         // evaluate aggregate function
/* 182 */         boolean agg_isNull7 = true;
/* 183 */         double agg_value8 = -1.0;
/* 184 */
/* 185 */         boolean agg_isNull9 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 186 */         double agg_value10 = agg_isNull9 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 187 */         boolean agg_isNull8 = agg_isNull9;
/* 188 */         double agg_value9 = agg_value10;
/* 189 */         if (agg_isNull8) {
/* 190 */           boolean agg_isNull10 = false;
/* 191 */           double agg_value11 = -1.0;
/* 192 */           if (!false) {
/* 193 */             agg_value11 = (double) 0;
/* 194 */           }
/* 195 */           if (!agg_isNull10) {
/* 196 */             agg_isNull8 = false;
/* 197 */             agg_value9 = agg_value11;
/* 198 */           }
/* 199 */         }
/* 200 */
/* 201 */         if (!inputadapter_isNull1) {
/* 202 */           agg_isNull7 = false; // resultCode could change nullability.
/* 203 */           agg_value8 = agg_value9 + inputadapter_value1;
/* 204 */
/* 205 */         }
/* 206 */         boolean agg_isNull6 = agg_isNull7;
/* 207 */         double agg_value7 = agg_value8;
/* 208 */         if (agg_isNull6) {
/* 209 */           boolean agg_isNull13 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 210 */           double agg_value14 = agg_isNull13 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 211 */           if (!agg_isNull13) {
/* 212 */             agg_isNull6 = false;
/* 213 */             agg_value7 = agg_value14;
/* 214 */           }
/* 215 */         }
/* 216 */         // update unsafe row buffer
/* 217 */         if (!agg_isNull6) {
/* 218 */           agg_unsafeRowAggBuffer.setDouble(0, agg_value7);
/* 219 */         } else {
/* 220 */           agg_unsafeRowAggBuffer.setNullAt(0);
/* 221 */         }
/* 222 */
/* 223 */       }
/* 224 */       if (shouldStop()) return;
/* 225 */     }
/* 226 */
/* 227 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 228 */   }
/* 229 */
/* 230 */   private void wholestagecodegen_init_1() {
/* 231 */     this.agg_aggTime1 = (org.apache.spark.sql.execution.metric.SQLMetric) references[6];
/* 232 */     agg_result2 = new UnsafeRow(1);
/* 233 */     this.agg_holder2 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result2, 0);
/* 234 */     this.agg_rowWriter2 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder2, 1);
/* 235 */
/* 236 */   }
/* 237 */
/* 238 */   protected void processNext() throws java.io.IOException {
/* 239 */     while (!agg_initAgg) {
/* 240 */       agg_initAgg = true;
/* 241 */       long agg_beforeAgg1 = System.nanoTime();
/* 242 */       agg_doAggregateWithoutKey();
/* 243 */       agg_aggTime1.add((System.nanoTime() - agg_beforeAgg1) / 1000000);
/* 244 */
/* 245 */       // output the result
/* 246 */
/* 247 */       agg_numOutputRows1.add(1);
/* 248 */       agg_rowWriter2.zeroOutNullBytes();
/* 249 */
/* 250 */       if (agg_bufIsNull) {
/* 251 */         agg_rowWriter2.setNullAt(0);
/* 252 */       } else {
/* 253 */         agg_rowWriter2.write(0, agg_bufValue);
/* 254 */       }
/* 255 */       append(agg_result2);
/* 256 */     }
/* 257 */   }
/* 258 */ }
