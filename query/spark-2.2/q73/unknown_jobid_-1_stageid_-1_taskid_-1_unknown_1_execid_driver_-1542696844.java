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
/* 028 */
/* 029 */   public GeneratedIterator(Object[] references) {
/* 030 */     this.references = references;
/* 031 */   }
/* 032 */
/* 033 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 034 */     partitionIndex = index;
/* 035 */     this.inputs = inputs;
/* 036 */     wholestagecodegen_init_0();
/* 037 */     wholestagecodegen_init_1();
/* 038 */
/* 039 */   }
/* 040 */
/* 041 */   private void wholestagecodegen_init_0() {
/* 042 */     scan_input = inputs[0];
/* 043 */     this.scan_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[0];
/* 044 */     this.scan_scanTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 045 */     scan_scanTime1 = 0;
/* 046 */     scan_batch = null;
/* 047 */     scan_batchIdx = 0;
/* 048 */     scan_colInstance0 = null;
/* 049 */     scan_colInstance1 = null;
/* 050 */     scan_colInstance2 = null;
/* 051 */     scan_colInstance3 = null;
/* 052 */     scan_result = new UnsafeRow(4);
/* 053 */     this.scan_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(scan_result, 32);
/* 054 */     this.scan_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(scan_holder, 4);
/* 055 */     this.filter_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 056 */     filter_result = new UnsafeRow(4);
/* 057 */     this.filter_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(filter_result, 32);
/* 058 */     this.filter_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(filter_holder, 4);
/* 059 */     project_result = new UnsafeRow(1);
/* 060 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 0);
/* 061 */
/* 062 */   }
/* 063 */
/* 064 */   private void scan_nextBatch() throws java.io.IOException {
/* 065 */     long getBatchStart = System.nanoTime();
/* 066 */     if (scan_input.hasNext()) {
/* 067 */       scan_batch = (org.apache.spark.sql.execution.vectorized.ColumnarBatch)scan_input.next();
/* 068 */       scan_numOutputRows.add(scan_batch.numRows());
/* 069 */       scan_batchIdx = 0;
/* 070 */       scan_colInstance0 = scan_batch.column(0);
/* 071 */       scan_colInstance1 = scan_batch.column(1);
/* 072 */       scan_colInstance2 = scan_batch.column(2);
/* 073 */       scan_colInstance3 = scan_batch.column(3);
/* 074 */
/* 075 */     }
/* 076 */     scan_scanTime1 += System.nanoTime() - getBatchStart;
/* 077 */   }
/* 078 */
/* 079 */   private void wholestagecodegen_init_1() {
/* 080 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 1);
/* 081 */
/* 082 */   }
/* 083 */
/* 084 */   protected void processNext() throws java.io.IOException {
/* 085 */     if (scan_batch == null) {
/* 086 */       scan_nextBatch();
/* 087 */     }
/* 088 */     while (scan_batch != null) {
/* 089 */       int scan_numRows = scan_batch.numRows();
/* 090 */       int scan_localEnd = scan_numRows - scan_batchIdx;
/* 091 */       for (int scan_localIdx = 0; scan_localIdx < scan_localEnd; scan_localIdx++) {
/* 092 */         int scan_rowIdx = scan_batchIdx + scan_localIdx;
/* 093 */         boolean scan_isNull1 = scan_colInstance1.isNullAt(scan_rowIdx);
/* 094 */         UTF8String scan_value1 = scan_isNull1 ? null : (scan_colInstance1.getUTF8String(scan_rowIdx));
/* 095 */
/* 096 */         boolean filter_isNull1 = true;
/* 097 */         boolean filter_value1 = false;
/* 098 */
/* 099 */         if (!scan_isNull1) {
/* 100 */           filter_isNull1 = false; // resultCode could change nullability.
/* 101 */           filter_value1 = scan_value1.equals(((UTF8String) references[3]));
/* 102 */
/* 103 */         }
/* 104 */         boolean filter_isNull = false;
/* 105 */         boolean filter_value = true;
/* 106 */
/* 107 */         if (!filter_isNull1 && filter_value1) {
/* 108 */         } else {
/* 109 */           boolean filter_isNull4 = true;
/* 110 */           boolean filter_value4 = false;
/* 111 */
/* 112 */           if (!scan_isNull1) {
/* 113 */             filter_isNull4 = false; // resultCode could change nullability.
/* 114 */             filter_value4 = scan_value1.equals(((UTF8String) references[4]));
/* 115 */
/* 116 */           }
/* 117 */           if (!filter_isNull4 && filter_value4) {
/* 118 */           } else if (!filter_isNull1 && !filter_isNull4) {
/* 119 */             filter_value = false;
/* 120 */           } else {
/* 121 */             filter_isNull = true;
/* 122 */           }
/* 123 */         }
/* 124 */         if (filter_isNull || !filter_value) continue;
/* 125 */         boolean scan_isNull3 = scan_colInstance3.isNullAt(scan_rowIdx);
/* 126 */         int scan_value3 = scan_isNull3 ? -1 : (scan_colInstance3.getInt(scan_rowIdx));
/* 127 */
/* 128 */         if (!(!(scan_isNull3))) continue;
/* 129 */
/* 130 */         boolean filter_isNull9 = false;
/* 131 */
/* 132 */         boolean filter_value9 = false;
/* 133 */         filter_value9 = scan_value3 > 0;
/* 134 */         if (!filter_value9) continue;
/* 135 */         boolean scan_isNull2 = scan_colInstance2.isNullAt(scan_rowIdx);
/* 136 */         int scan_value2 = scan_isNull2 ? -1 : (scan_colInstance2.getInt(scan_rowIdx));
/* 137 */
/* 138 */         boolean filter_isNull12 = true;
/* 139 */         boolean filter_value12 = false;
/* 140 */
/* 141 */         boolean filter_isNull13 = true;
/* 142 */         double filter_value13 = -1.0;
/* 143 */
/* 144 */         boolean filter_isNull14 = false;
/* 145 */
/* 146 */         boolean filter_value14 = false;
/* 147 */         filter_value14 = scan_value3 > 0;
/* 148 */         if (!false && filter_value14) {
/* 149 */           boolean filter_isNull20 = scan_isNull3;
/* 150 */           double filter_value20 = -1.0;
/* 151 */           if (!scan_isNull3) {
/* 152 */             filter_value20 = (double) scan_value3;
/* 153 */           }
/* 154 */           boolean filter_isNull17 = false;
/* 155 */           double filter_value17 = -1.0;
/* 156 */           if (filter_isNull20 || filter_value20 == 0) {
/* 157 */             filter_isNull17 = true;
/* 158 */           } else {
/* 159 */             boolean filter_isNull18 = scan_isNull2;
/* 160 */             double filter_value18 = -1.0;
/* 161 */             if (!scan_isNull2) {
/* 162 */               filter_value18 = (double) scan_value2;
/* 163 */             }
/* 164 */             if (filter_isNull18) {
/* 165 */               filter_isNull17 = true;
/* 166 */             } else {
/* 167 */               filter_value17 = (double)(filter_value18 / filter_value20);
/* 168 */             }
/* 169 */           }
/* 170 */           filter_isNull13 = filter_isNull17;
/* 171 */           filter_value13 = filter_value17;
/* 172 */         }
/* 173 */
/* 174 */         else {
/* 175 */           final double filter_value22 = -1.0;
/* 176 */           filter_isNull13 = true;
/* 177 */           filter_value13 = filter_value22;
/* 178 */         }
/* 179 */         if (!filter_isNull13) {
/* 180 */           filter_isNull12 = false; // resultCode could change nullability.
/* 181 */           filter_value12 = org.apache.spark.util.Utils.nanSafeCompareDoubles(filter_value13, 1.0D) > 0;
/* 182 */
/* 183 */         }
/* 184 */         if (filter_isNull12 || !filter_value12) continue;
/* 185 */
/* 186 */         boolean scan_isNull = scan_colInstance0.isNullAt(scan_rowIdx);
/* 187 */         int scan_value = scan_isNull ? -1 : (scan_colInstance0.getInt(scan_rowIdx));
/* 188 */
/* 189 */         if (!(!(scan_isNull))) continue;
/* 190 */
/* 191 */         filter_numOutputRows.add(1);
/* 192 */
/* 193 */         project_rowWriter.write(0, scan_value);
/* 194 */         append(project_result);
/* 195 */         if (shouldStop()) { scan_batchIdx = scan_rowIdx + 1; return; }
/* 196 */       }
/* 197 */       scan_batchIdx = scan_numRows;
/* 198 */       scan_batch = null;
/* 199 */       scan_nextBatch();
/* 200 */     }
/* 201 */     scan_scanTime.add(scan_scanTime1 / (1000 * 1000));
/* 202 */     scan_scanTime1 = 0;
/* 203 */   }
/* 204 */ }
