/* 001 */ public Object generate(Object[] references) {
/* 002 */   return new GeneratedIterator(references);
/* 003 */ }
/* 004 */
/* 005 */ final class GeneratedIterator extends org.apache.spark.sql.execution.BufferedRowIterator {
/* 006 */   private Object[] references;
/* 007 */   private scala.collection.Iterator[] inputs;
/* 008 */   private scala.collection.Iterator scan_input;
/* 009 */   private org.apache.spark.sql.execution.metric.SQLMetric scan_numOutputRows;
/* 010 */   private org.apache.spark.sql.execution.metric.SQLMetric scan_scanTime;
/* 011 */   private long scan_scanTime1;
/* 012 */   private org.apache.spark.sql.execution.vectorized.ColumnarBatch scan_batch;
/* 013 */   private int scan_batchIdx;
/* 014 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance0;
/* 015 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance1;
/* 016 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance2;
/* 017 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance3;
/* 018 */   private UnsafeRow scan_result;
/* 019 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder scan_holder;
/* 020 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter scan_rowWriter;
/* 021 */   private org.apache.spark.sql.execution.metric.SQLMetric filter_numOutputRows;
/* 022 */   private UnsafeRow filter_result;
/* 023 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder filter_holder;
/* 024 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter filter_rowWriter;
/* 025 */   private UnsafeRow project_result;
/* 026 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder;
/* 027 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter;
/* 028 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast;
/* 029 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation;
/* 030 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows;
/* 031 */   private UnsafeRow bhj_result;
/* 032 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder;
/* 033 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter;
/* 034 */   private UnsafeRow project_result1;
/* 035 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder1;
/* 036 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter1;
/* 037 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast1;
/* 038 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation1;
/* 039 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows1;
/* 040 */   private UnsafeRow bhj_result1;
/* 041 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder1;
/* 042 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter1;
/* 043 */   private UnsafeRow project_result2;
/* 044 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder2;
/* 045 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter2;
/* 046 */
/* 047 */   public GeneratedIterator(Object[] references) {
/* 048 */     this.references = references;
/* 049 */   }
/* 050 */
/* 051 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 052 */     partitionIndex = index;
/* 053 */     this.inputs = inputs;
/* 054 */     wholestagecodegen_init_0();
/* 055 */     wholestagecodegen_init_1();
/* 056 */     wholestagecodegen_init_2();
/* 057 */
/* 058 */   }
/* 059 */
/* 060 */   private void wholestagecodegen_init_0() {
/* 061 */     scan_input = inputs[0];
/* 062 */     this.scan_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[0];
/* 063 */     this.scan_scanTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 064 */     scan_scanTime1 = 0;
/* 065 */     scan_batch = null;
/* 066 */     scan_batchIdx = 0;
/* 067 */     scan_colInstance0 = null;
/* 068 */     scan_colInstance1 = null;
/* 069 */     scan_colInstance2 = null;
/* 070 */     scan_colInstance3 = null;
/* 071 */     scan_result = new UnsafeRow(4);
/* 072 */     this.scan_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(scan_result, 0);
/* 073 */     this.scan_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(scan_holder, 4);
/* 074 */     this.filter_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 075 */     filter_result = new UnsafeRow(4);
/* 076 */     this.filter_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(filter_result, 0);
/* 077 */     this.filter_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(filter_holder, 4);
/* 078 */     project_result = new UnsafeRow(4);
/* 079 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 0);
/* 080 */
/* 081 */   }
/* 082 */
/* 083 */   private void scan_nextBatch() throws java.io.IOException {
/* 084 */     long getBatchStart = System.nanoTime();
/* 085 */     if (scan_input.hasNext()) {
/* 086 */       scan_batch = (org.apache.spark.sql.execution.vectorized.ColumnarBatch)scan_input.next();
/* 087 */       scan_numOutputRows.add(scan_batch.numRows());
/* 088 */       scan_batchIdx = 0;
/* 089 */       scan_colInstance0 = scan_batch.column(0);
/* 090 */       scan_colInstance1 = scan_batch.column(1);
/* 091 */       scan_colInstance2 = scan_batch.column(2);
/* 092 */       scan_colInstance3 = scan_batch.column(3);
/* 093 */
/* 094 */     }
/* 095 */     scan_scanTime1 += System.nanoTime() - getBatchStart;
/* 096 */   }
/* 097 */
/* 098 */   private void wholestagecodegen_init_2() {
/* 099 */     bhj_relation1 = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast1.value()).asReadOnlyCopy();
/* 100 */     incPeakExecutionMemory(bhj_relation1.estimatedSize());
/* 101 */
/* 102 */     this.bhj_numOutputRows1 = (org.apache.spark.sql.execution.metric.SQLMetric) references[6];
/* 103 */     bhj_result1 = new UnsafeRow(7);
/* 104 */     this.bhj_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result1, 32);
/* 105 */     this.bhj_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder1, 7);
/* 106 */     project_result2 = new UnsafeRow(6);
/* 107 */     this.project_holder2 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result2, 64);
/* 108 */     this.project_rowWriter2 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder2, 6);
/* 109 */
/* 110 */   }
/* 111 */
/* 112 */   private void wholestagecodegen_init_1() {
/* 113 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 4);
/* 114 */     this.bhj_broadcast = (org.apache.spark.broadcast.TorrentBroadcast) references[3];
/* 115 */
/* 116 */     bhj_relation = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast.value()).asReadOnlyCopy();
/* 117 */     incPeakExecutionMemory(bhj_relation.estimatedSize());
/* 118 */
/* 119 */     this.bhj_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[4];
/* 120 */     bhj_result = new UnsafeRow(6);
/* 121 */     this.bhj_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result, 32);
/* 122 */     this.bhj_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder, 6);
/* 123 */     project_result1 = new UnsafeRow(4);
/* 124 */     this.project_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result1, 32);
/* 125 */     this.project_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder1, 4);
/* 126 */     this.bhj_broadcast1 = (org.apache.spark.broadcast.TorrentBroadcast) references[5];
/* 127 */
/* 128 */   }
/* 129 */
/* 130 */   protected void processNext() throws java.io.IOException {
/* 131 */     if (scan_batch == null) {
/* 132 */       scan_nextBatch();
/* 133 */     }
/* 134 */     while (scan_batch != null) {
/* 135 */       int scan_numRows = scan_batch.numRows();
/* 136 */       int scan_localEnd = scan_numRows - scan_batchIdx;
/* 137 */       for (int scan_localIdx = 0; scan_localIdx < scan_localEnd; scan_localIdx++) {
/* 138 */         int scan_rowIdx = scan_batchIdx + scan_localIdx;
/* 139 */         boolean scan_isNull = scan_colInstance0.isNullAt(scan_rowIdx);
/* 140 */         int scan_value = scan_isNull ? -1 : (scan_colInstance0.getInt(scan_rowIdx));
/* 141 */
/* 142 */         if (!scan_isNull) continue;
/* 143 */
/* 144 */         boolean scan_isNull1 = scan_colInstance1.isNullAt(scan_rowIdx);
/* 145 */         int scan_value1 = scan_isNull1 ? -1 : (scan_colInstance1.getInt(scan_rowIdx));
/* 146 */
/* 147 */         if (!(!(scan_isNull1))) continue;
/* 148 */
/* 149 */         filter_numOutputRows.add(1);
/* 150 */
/* 151 */         // generate join key for stream side
/* 152 */
/* 153 */         boolean bhj_isNull = false;
/* 154 */         long bhj_value = -1L;
/* 155 */         if (!false) {
/* 156 */           bhj_value = (long) scan_value1;
/* 157 */         }
/* 158 */         // find matches from HashedRelation
/* 159 */         UnsafeRow bhj_matched = bhj_isNull ? null: (UnsafeRow)bhj_relation.getValue(bhj_value);
/* 160 */         if (bhj_matched == null) continue;
/* 161 */
/* 162 */         bhj_numOutputRows.add(1);
/* 163 */
/* 164 */         boolean scan_isNull3 = scan_colInstance3.isNullAt(scan_rowIdx);
/* 165 */         int scan_value3 = scan_isNull3 ? -1 : (scan_colInstance3.getInt(scan_rowIdx));
/* 166 */
/* 167 */         // generate join key for stream side
/* 168 */
/* 169 */         boolean bhj_isNull10 = scan_isNull3;
/* 170 */         long bhj_value10 = -1L;
/* 171 */         if (!scan_isNull3) {
/* 172 */           bhj_value10 = (long) scan_value3;
/* 173 */         }
/* 174 */         // find matches from HashedRelation
/* 175 */         UnsafeRow bhj_matched1 = bhj_isNull10 ? null: (UnsafeRow)bhj_relation1.getValue(bhj_value10);
/* 176 */         if (bhj_matched1 == null) continue;
/* 177 */
/* 178 */         bhj_numOutputRows1.add(1);
/* 179 */
/* 180 */         boolean bhj_isNull13 = bhj_matched1.isNullAt(1);
/* 181 */         int bhj_value13 = bhj_isNull13 ? -1 : (bhj_matched1.getInt(1));
/* 182 */         boolean bhj_isNull14 = bhj_matched1.isNullAt(2);
/* 183 */         int bhj_value14 = bhj_isNull14 ? -1 : (bhj_matched1.getInt(2));
/* 184 */         boolean bhj_isNull3 = bhj_matched.isNullAt(1);
/* 185 */         UTF8String bhj_value3 = bhj_isNull3 ? null : (bhj_matched.getUTF8String(1));
/* 186 */         boolean scan_isNull2 = scan_colInstance2.isNullAt(scan_rowIdx);
/* 187 */         double scan_value2 = scan_isNull2 ? -1.0 : (scan_colInstance2.getDouble(scan_rowIdx));
/* 188 */         project_holder2.reset();
/* 189 */
/* 190 */         project_rowWriter2.zeroOutNullBytes();
/* 191 */
/* 192 */         project_rowWriter2.write(0, ((UTF8String) references[7]));
/* 193 */
/* 194 */         if (scan_isNull) {
/* 195 */           project_rowWriter2.setNullAt(1);
/* 196 */         } else {
/* 197 */           project_rowWriter2.write(1, scan_value);
/* 198 */         }
/* 199 */
/* 200 */         if (bhj_isNull13) {
/* 201 */           project_rowWriter2.setNullAt(2);
/* 202 */         } else {
/* 203 */           project_rowWriter2.write(2, bhj_value13);
/* 204 */         }
/* 205 */
/* 206 */         if (bhj_isNull14) {
/* 207 */           project_rowWriter2.setNullAt(3);
/* 208 */         } else {
/* 209 */           project_rowWriter2.write(3, bhj_value14);
/* 210 */         }
/* 211 */
/* 212 */         if (bhj_isNull3) {
/* 213 */           project_rowWriter2.setNullAt(4);
/* 214 */         } else {
/* 215 */           project_rowWriter2.write(4, bhj_value3);
/* 216 */         }
/* 217 */
/* 218 */         if (scan_isNull2) {
/* 219 */           project_rowWriter2.setNullAt(5);
/* 220 */         } else {
/* 221 */           project_rowWriter2.write(5, scan_value2);
/* 222 */         }
/* 223 */         project_result2.setTotalSize(project_holder2.totalSize());
/* 224 */         append(project_result2);
/* 225 */         if (shouldStop()) { scan_batchIdx = scan_rowIdx + 1; return; }
/* 226 */       }
/* 227 */       scan_batchIdx = scan_numRows;
/* 228 */       scan_batch = null;
/* 229 */       scan_nextBatch();
/* 230 */     }
/* 231 */     scan_scanTime.add(scan_scanTime1 / (1000 * 1000));
/* 232 */     scan_scanTime1 = 0;
/* 233 */   }
/* 234 */ }
